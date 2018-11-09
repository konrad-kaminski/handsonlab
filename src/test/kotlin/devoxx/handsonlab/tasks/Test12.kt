package devoxx.handsonlab.tasks

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

/**
 * Tests for [sendMessageWithCancel].
 */
@Tag("part2")
class Test12: AbstractTest() {
    @Test
    fun `should break delaying coroutine on cancel and wait for the coroutine to be finished`() {
        //when
        val timeMillis = measureTimeMillis {
            sendMessageWithCancel("ABC")
        }

        //then
        assertTrue(timeMillis < 2_000)
        assertEquals(listOf("ABC"), messages)
        assertEquals(0, sendMessageLatch.count)
    }
}
