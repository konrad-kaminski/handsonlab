package devoxx.handsonlab.tasks

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.future.await
import kotlinx.coroutines.future.future
import java.util.concurrent.CompletableFuture


/**
 * Implement [createSuspendingMessageSender] function, which returns an implementation of [SuspendingMessageSender] which delegate calls
 * to [sender].
 */
fun createSuspendingMessageSender(sender: CompletableFutureMessageSender): SuspendingMessageSender = TODO()

/**
 * Implement [createCompletableFutureMessageSender] function, which returns an implementation of [CompletableFutureMessageSender] which delegate calls
 * to [sender].
 */
fun CoroutineScope.createCompletableFutureMessageSender(sender: SuspendingMessageSender): CompletableFutureMessageSender = TODO()

interface CompletableFutureMessageSender {
    fun sendMessage(msg: String): CompletableFuture<String>
}

interface SuspendingMessageSender {
    suspend fun sendMessage(msg: String): String
}

