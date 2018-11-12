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
fun createSuspendingMessageSender(sender: CompletableFutureMessageSender): SuspendingMessageSender =
    object: SuspendingMessageSender {
        override suspend fun sendMessage(msg: String): String =
            sender.sendMessage(msg).await()
    }

/**
 * Implement [createCompletableFutureMessageSender] function, which returns an implementation of [CompletableFutureMessageSender] which delegate calls
 * to [sender].
 */
fun CoroutineScope.createCompletableFutureMessageSender(sender: SuspendingMessageSender): CompletableFutureMessageSender =
    object: CompletableFutureMessageSender {
        override fun sendMessage(msg: String): CompletableFuture<String> = future(Dispatchers.Default) {
            sender.sendMessage(msg)
        }
    }

interface CompletableFutureMessageSender {
    fun sendMessage(msg: String): CompletableFuture<String>
}

interface SuspendingMessageSender {
    suspend fun sendMessage(msg: String): String
}

