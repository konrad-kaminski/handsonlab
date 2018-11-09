package devoxx.handsonlab.tasks

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

/**
 * Tests for [separateThreadReturn].
 */
@Tag("part1")
class Test6 {
    @Test
    fun `should use separate thread to return a value after some sleep`() {
        //when
        lateinit var result: String
        lateinit var threadName: String

        val timeMillis = measureTimeMillis {
            runBlocking(Dispatchers.Unconfined) {
                result = separateThreadReturn("custom-thread", "ABC")
                threadName = Thread.currentThread().name
            }
        }

        //then
        assertEquals("ABC", result)
        assertTrue(threadName.startsWith("custom-thread"))
        assertTrue(timeMillis > 2_000) { "Waited less than 2 seconds." }
        assertTrue(timeMillis < 2_500) { "Waited more than 2.5 seconds." }
    }

    @Test
    fun `should delay for 2 seonds and then use separate thread to return a value`() {
        //when
        lateinit var result: String
        lateinit var threadName: String

        val timeMillis = measureTimeMillis {
            runBlocking(Dispatchers.Unconfined) {
                result = separateThreadReturn2("custom-thread", "ABC")
                threadName = Thread.currentThread().name
            }
        }

        //then
        assertEquals("ABC", result)
        assertTrue(threadName.startsWith("custom-thread"))
        assertTrue(timeMillis > 2_000) { "Waited less than 2 seconds." }
        assertTrue(timeMillis < 2_500) { "Waited more than 2.5 seconds." }
    }
}
