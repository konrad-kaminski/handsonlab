package devoxx.handsonlab.tasks

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import java.util.concurrent.ConcurrentLinkedQueue

/**
 * Tests for [sendFromMultipleCoroutines].
 */
@Tag("part3")
class Test23 : AbstractTest() {
    @Test
    fun `should create a new channel and send a message to it using produce`() {
        //when
        val result = ConcurrentLinkedQueue<Int>()
        runBlocking {
            val channel = Channel<Int>()
            launch(Dispatchers.Default) {
                channel.consumeEach {
                    result += it
                }
            }
            sendFromMultipleCoroutines(10_000, channel)
            channel.close()
        }


        //then
        assertEquals((1..10_000).toList(), result.sorted())
    }
}