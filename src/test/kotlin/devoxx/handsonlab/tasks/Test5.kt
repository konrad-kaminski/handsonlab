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
    @Test
    fun `should properly delegate calls for regular calls`() = runBlocking {
        //given
        val task5 = Task5(object : SuspendingInterface {
            override suspend fun execute(p: Int): Int {
                check(p == 0) { "Expected 0 as input" }
                return 1
            }
        })

        //when
        val result = task5.execute(0)

        //then
        assertEquals(6, result)
    }

    @Test
    fun `should properly delegate calls for suspended calls`() = runBlocking {
        //given
        val task5 = Task5(object : SuspendingInterface {
            override suspend fun execute(p: Int): Int {
                check(p == 1) { "Expected 1 as input" }
                delay(1)
                return 2
            }
        })

        //when
        val result = task5.execute(1)

        //then
        assertEquals(7, result)
    }
}
