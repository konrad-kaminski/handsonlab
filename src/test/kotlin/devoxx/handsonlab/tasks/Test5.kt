package devoxx.handsonlab.tasks

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

/**
 * Tests for [Task5].
 */
@Tag("part1")
class Test5 {
    private val TARGET = object: SuspendingInterface {
        override suspend fun execute(p: Int): Int = (p + 1).also {
            if (p > 0) {
                delay(p.toLong())
            }
        }
    }

    @Test
    fun `should properly delegate calls for regular calls`() = runBlocking {
        //given
        val task5 = Task5(TARGET)

        //when
        val result = task5.execute(0)

        //then
        assertEquals(6, result)
    }

    @Test
    fun `should properly delegate calls for suspended calls`() = runBlocking {
        //given
        val task5 = Task5(TARGET)

        //when
        val result = task5.execute(1)

        //then
        assertEquals(7, result)
    }
}
