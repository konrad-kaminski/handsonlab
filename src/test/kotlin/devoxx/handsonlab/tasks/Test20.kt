package devoxx.handsonlab.tasks

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.toList
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

/**
 * Tests for [sendMessageToChannel] and [sendMessagesReceivedFromChannel].
 */
@Tag("part4")
class Test20: AbstractTest() {
    @Test
    fun `should create a new channel and send a message to it`() {
        //when
        val result = runBlocking {
            sendMessageToChannel("ABC").toList()
        }

        //then
        assertEquals(listOf("ABC"), result)
    }

    @Test
    fun `should send messages received from a channel`() {
        // given
        val channel = runBlocking {
            Channel<String>(2).apply {
                send("ABC")
                send("CDE")
                close()
            }
        }

        //when
        runBlocking {
            sendMessagesReceivedFromChannel(channel)
        }

        //then
        assertEquals(listOf("ABC", "CDE"), messages)
    }
}