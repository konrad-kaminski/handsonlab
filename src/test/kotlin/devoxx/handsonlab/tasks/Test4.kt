package devoxx.handsonlab.tasks

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread

/**
 * Tests for [sendMultipleWithSleep] and [sendMultipleWithDelay].
 */
@Tag("part1")
class Test4a: AbstractTest() {
    @Test
    fun `should be able to send 100_000 messages with delay`() {
        //given
        val counter = AtomicInteger(0)
        onSendMessage = {
            if (it != "ABC") throw Exception("Incorrect message. Expected 'ABC' and received '$it'")
            counter.incrementAndGet()
        }

        //when
        sendMultipleWithDelay(100_000, "ABC")

        //then
        assertEquals(100_000, counter.get())
    }

}

@Tag("part1")
class Test4b: AbstractTest() {
    @Test
    fun `should not be able to send 100_000 messages with sleep`() {
        //given
        val counter = AtomicInteger(0)
        onSendMessage = {
            if (it != "ABC") throw Exception("Incorrect message. Expected 'ABC' and received '$it'")
            counter.incrementAndGet()
        }

        //when
        val testThread = thread {
            sendMultipleWithSleep(100_000, "ABC")
        }

        testThread.join(3_000)

        //then
        assertTrue(counter.get() > 0)
        assertTrue(counter.get() < 100_000)
    }
}
