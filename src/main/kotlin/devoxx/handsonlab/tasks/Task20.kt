package devoxx.handsonlab.tasks

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch

/**
 * Implement [sendMessageToChannel] function, which should create a new channel and
 * send [msg] to it. The channel should be returned as the result of the function so that
 * another coroutine could read all messages from it (meaning exactly one message that you just sent).
 * Use [GlobalScope].
 */
suspend fun sendMessageToChannel(msg: String): ReceiveChannel<String> = TODO()

/**
 * Implement [sendMessagesReceivedFromChannel] function, which should receive all messages from
 * the [channel] and send it using [sendMessage].
 */
suspend fun sendMessagesReceivedFromChannel(channel: ReceiveChannel<String>): Unit = TODO()