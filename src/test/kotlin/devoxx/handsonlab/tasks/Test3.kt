package devoxx.handsonlab.tasks

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

/**
 * Tests for [sendDelayedUsingJobJoin].
 */
@Tag("part1")
class Test3: AbstractTest() {

    @Test
    fun `should send delayed message with job join`() {
        //when
        val timeMillis = measureTimeMillis {
            runBlocking {
                sendDelayedUsingJobJoin("ABC")
            }
        }

        //then
        assertEquals(messages, listOf("ABC"))
        assertTrue(timeMillis > 2_000) { "Waited less than 2 seconds." }
        assertTrue(timeMillis < 2_500) { "Waited more than 2.5 seconds." }
    }
}
