package devoxx.handsonlab.tasks

import kotlinx.coroutines.channels.toList
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

/**
 * Tests for [produceNumbers] and [filterNumbers].
 */
@Tag("part3")
class Test22 : AbstractTest() {
    @Test
    fun `should create a pipeline of operations on channels`() {
        //when
        val result = runBlocking {
            produceNumbers(1, 10)
                .let(::filterNumbers)
                .let(::mapNumbersToStrings)
                .toList()
        }


        //then
        assertEquals(listOf("2", "4", "6", "8", "10"), result)
    }
}