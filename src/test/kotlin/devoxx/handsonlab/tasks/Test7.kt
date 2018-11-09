package devoxx.handsonlab.tasks

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

/**
 * Tests for [sendMessagesWithTwoCoroutines].
 */
@Tag("part1")
class Test7: AbstractTest() {
    @Test
    fun `should send two messages - second after first`() {
        //when
        sendMessagesWithTwoCoroutines("ABC", "CDE")

        //then
        assertEquals(listOf("CDE", "ABC"), messages)
    }
}
