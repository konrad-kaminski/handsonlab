package devoxx.handsonlab.tasks

import kotlinx.coroutines.channels.toList
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

/**
 * Tests for [produceMessageToChannel].
 */
@Tag("part3")
class Test21: AbstractTest() {
    @Test
    fun `should create a new channel and send a message to it using produce`() {
        //when
        val result = runBlocking {
            val ch = produceMessageToChannel("ABC")

                ch.toList()
        }


        //then
        assertEquals(listOf("ABC"), result)
    }
}