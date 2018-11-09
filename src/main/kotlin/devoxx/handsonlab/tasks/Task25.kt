package devoxx.handsonlab.tasks

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock


/**
 * Implement [createCountingActor] function, which should create a [SendChannel] using [actor].
 * The actor should contain a state (totalValue = 0 at the start) and handle two messages:
 * 1. IncrementMessage -> the value should be added to the current totalValue.
 * 2. GetTotalMessage -> the totalValue should be sent to the replyTo channel.
 */
fun CoroutineScope.createCountingActor(): SendChannel<Message> = TODO()

sealed class Message {
    data class IncrementMessage(val value: Int): Message()
    data class GetTotalMessage(val replyTo: SendChannel<Int>): Message()
}