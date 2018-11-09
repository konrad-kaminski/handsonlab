package devoxx.handsonlab.tasks

import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import kotlin.system.measureTimeMillis

/**
 * Tests for [sendMessageWithTimeout].
 */
@Tag("part2")
class Test14: AbstractTest() {
    @Test
    fun `should throw an exception on timeout`() {
        //when
        val timeMillis = measureTimeMillis {
            try {
                runBlocking {
                    sendMessageWithTimeout("ABC")
                }

                fail("sendMessageWithTimeout should have timeouted with TimeoutCancellationException")
            } catch (e: TimeoutCancellationException) {
                // we expect this
            }
        }

        //then
        assertTrue(timeMillis > 1_000)
        assertTrue(timeMillis < 2_000)
        assertEquals(emptyList<String>(), messages)
    }
}
