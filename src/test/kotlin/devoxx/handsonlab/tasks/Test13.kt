package devoxx.handsonlab.tasks

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

/**
 * Tests for [sendMessageCPUConsumingWithCancel].
 */
@Tag("part2")
class Test13: AbstractTest() {
    @Test
    fun `should not break CPU consuming coroutine on cancel and wait for the coroutine to be finished`() {
        //when
        val timeMillis = measureTimeMillis {
            sendMessageCPUConsumingWithCancel("ABC")
        }

        //then
        assertTrue(timeMillis > 2_000)
        assertEquals(listOf("ABC"), messages)
        assertEquals(0, sendMessageLatch.count)
    }
}
