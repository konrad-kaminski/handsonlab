package devoxx.handsonlab.tasks

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

/**
 * Tests for [sendMessageWithAsync].
 */
@Tag("part3")
class Test18: AbstractTest() {
    @Test
    fun `should be able to cancel all children`() {
        //when
        val result = runBlocking {
            sendMessageWithAsync("ABC").await()
        }

        //then
        assertEquals("sent: ABC", result)
        assertEquals(listOf("ABC"), messages)
    }
}
