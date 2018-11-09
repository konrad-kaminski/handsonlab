package devoxx.handsonlab.tasks

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

/**
 * Tests for [sendMessageWithAllChildrenCancel].
 */
@Tag("part2")
class Test16: AbstractTest() {
    @Test
    fun `should be able to cancel all children`() {
        //when
        val timeMillis = measureTimeMillis {
            runBlocking {
                sendMessageWithAllChildrenCancel("ABC")
            }
        }

        //then
        assertTrue(timeMillis > 1_000)
        assertTrue(timeMillis < 5_000)
        assertEquals(emptyList<String>(), messages)
    }
}
