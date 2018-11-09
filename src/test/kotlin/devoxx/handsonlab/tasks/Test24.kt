package devoxx.handsonlab.tasks

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

/**
 * Tests for [createCounter].
 */
@Tag("part3")
class Test24 : AbstractTest() {
    @Test
    fun `should create a proper Counter implementation`() {
        //when
        val counter = createCounter(7)
        runBlocking {
            (1..10_000).forEach {
                launch(Dispatchers.Default) {
                    counter.inc()
                }
            }
        }

        val counterValue = runBlocking { counter.current() }

        //then
        assertEquals(10_007, counterValue)
    }
}