package devoxx.handsonlab.tasks

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

/**
 * Tests for [suspendingSendMessagesWithTwoCoroutines].
 */
@Tag("part1")
class Test8: AbstractTest() {
    @Test
    fun `should send two messages - second after first`() {
        //when
        runBlocking {
            suspendingSendMessagesWithTwoCoroutines("ABC", "CDE")
        }

        //then
        assertEquals(listOf("CDE", "ABC"), messages)
    }
}
