package devoxx.handsonlab.tasks

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import kotlin.system.measureTimeMillis

/**
 * Tests for [blockingSendDelayedMessage].
 */
@Tag("part1")
class Test2: AbstractTest() {
    @Test
    fun `should send delayed message in runBlocking`() {
        //when
        val timeMillis = measureTimeMillis {
            blockingSendDelayedMessage("CDE")
        }

        //then
        assertEquals(listOf("CDE"), messages)
        assertTrue(timeMillis > 2_000) { "Waited less than 2 seconds." }
        assertTrue(timeMillis < 2_500) { "Waited more than 2.5 seconds." }
    }
}
