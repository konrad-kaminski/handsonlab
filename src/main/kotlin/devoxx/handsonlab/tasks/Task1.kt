package devoxx.handsonlab.tasks

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
  Implement [sendDelayedMessage] function, which should start a new coroutine in [GlobalScope].
  The coroutine should wait for 2 seconds and then [sendMessage] with [msg] as a parameter.
 */
fun sendDelayedMessage(msg: String) {
    GlobalScope.launch {
        delay(2_000)
        sendMessage(msg)
    }
}