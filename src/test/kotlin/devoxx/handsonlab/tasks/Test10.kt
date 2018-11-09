package devoxx.handsonlab.tasks

import kotlinx.coroutines.CoroutineName
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import java.util.concurrent.TimeUnit
import kotlin.coroutines.coroutineContext

/**
 * Tests for [sendMessageInNewThreadContext].
 */
@Tag("part2")
class Test10: AbstractTest() {
    @Test
    fun `should send message in GlobalScope launch in named coroutine`() {
        //when
        lateinit var coroutineName: String
        lateinit var threadName: String

        addOnMessageHandler {
            coroutineName = coroutineContext[CoroutineName]!!.name
            threadName = Thread.currentThread().name
        }
        sendMessageInNewThreadContext("sender-coroutine", "thread-name", "ABC")
        sendMessageLatch.await(1, TimeUnit.SECONDS)

        //then
        assertTrue("thread-name" in threadName)
        assertEquals("sender-coroutine", coroutineName)
        assertEquals(listOf("ABC"), messages)
    }
}
