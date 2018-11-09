package devoxx.handsonlab.tasks

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

/**
 * Tests for [sendMessageWithGlobalScopeCancel].
 */
@Tag("part2")
class Test11: AbstractTest() {
    @Test
    fun `should break delaying coroutine on cancel`() {
        //when
        val timeMillis = measureTimeMillis {
            sendMessageWithGlobalScopeCancel("ABC")
        }

        //then
        assertTrue(timeMillis < 2_000)
        assertEquals(emptyList<String>(), messages)
    }
}
