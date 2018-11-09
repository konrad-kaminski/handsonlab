package devoxx.handsonlab.tasks

import kotlinx.coroutines.CoroutineName
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import java.util.concurrent.TimeUnit
import kotlin.coroutines.coroutineContext

/**
 * Tests for [sendMessageInNamedCoroutine].
 */
@Tag("part2")
class Test9: AbstractTest() {
    @Test
    fun `should send coroutine name in GlobalScope launch in named coroutine`() {
        //when
        lateinit var coroutineName: String
        addOnMessageHandler {
            coroutineName = coroutineContext[CoroutineName]!!.name
        }
        sendMessageInNamedCoroutine("sender-coroutine")
        sendMessageLatch.await(1, TimeUnit.SECONDS)

        //then
        assertEquals("sender-coroutine", coroutineName)
        assertEquals(listOf("sender-coroutine"), messages)
    }
}
