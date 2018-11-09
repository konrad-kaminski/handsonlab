package devoxx.handsonlab.tasks

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

/**
 * Tests for [sendMessageWithAsync].
 */
@Tag("part3")
class Test19: AbstractTest() {
    @Test
    fun `should send messages concurrently in two threads`() {
        //when
        lateinit var result: Pair<String, String>
        val timeMillis = measureTimeMillis {
            runBlocking {
                result = sendMessagesWithAsync("ABC", "CDE")
            }
        }

        //then
        assertTrue(timeMillis >= 2_000)
        assertTrue(timeMillis < 3_000)
        assertEquals("sent: ABC" to "sent: CDE", result)
        assertEquals(setOf("ABC", "CDE"), messages.toSet())
    }
}
