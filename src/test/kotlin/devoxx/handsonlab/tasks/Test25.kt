package devoxx.handsonlab.tasks

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

/**
 * Tests for [createCountingActor].
 */
@Tag("part3")
class Test25 : AbstractTest() {
    @Test
    fun `should add up all values in counting actor`() {
        //when
        val totalValue = runBlocking {
            val actor = createCountingActor()

            (1..10_000).map { value ->
                launch(Dispatchers.Default) {
                    actor.send(Message.IncrementMessage(value))
                }
            }.joinAll()

            val resultChannel = Channel<Int>()

            actor.send(Message.GetTotalMessage(resultChannel))

            resultChannel.receive().also {
                actor.close()
            }
        }

        //then
        assertEquals((10_000*10_001)/2, totalValue)
    }
}