package devoxx.handsonlab.tasks

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import java.util.concurrent.TimeUnit
import kotlin.system.measureTimeMillis

/**
 * Tests for [sendDelayedMessage].
 */
@Tag("part1")
class Test1: AbstractTest() {
    @Test
    fun `should send delayed message in GlobalScope launch`() {
        //when
        sendDelayedMessage("ABC")

        val timeMillis = measureTimeMillis {
            sendMessageLatch.await(3, TimeUnit.SECONDS)
        }

        //then
        assertEquals(messages, listOf("ABC"))
        assertTrue(timeMillis > 2_000) { "Waited less than 2 seconds." }
    }
}
