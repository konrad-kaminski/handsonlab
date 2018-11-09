package devoxx.handsonlab.tasks

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import java.util.concurrent.CompletableFuture

/**
 * Tests for [createSuspendingMessageSender] and [createCompletableFutureMessageSender].
 */
@Tag("part3")
class Test26 : AbstractTest() {
    @Test
    fun `should create SuspendingMessageSender from CompletableFutureMessageSender`() {
        //given
        val testSender = TestCompletableFutureMessageSender()

        //when
        val result = runBlocking {
            createSuspendingMessageSender(testSender).sendMessage("ABC")
        }

        //then
        assertEquals("sent: ABC", result)
        assertEquals(listOf("ABC"), testSender.messages)
    }

    @Test
    fun `should create CompletableFutureMessageSender from SuspendingMessageSender`() {
        //given
        val testSender = TestSuspendingMessageSender()

        //when
        val result = runBlocking {
            createCompletableFutureMessageSender(testSender).sendMessage("ABC").get()
        }

        //then
        assertEquals("sent: ABC", result)
        assertEquals(listOf("ABC"), testSender.messages)
    }
}

private class TestSuspendingMessageSender: SuspendingMessageSender {
    val messages = mutableListOf<String>()

    override suspend fun sendMessage(msg: String): String {
        messages += msg
        return "sent: $msg"
    }
}

private class TestCompletableFutureMessageSender: CompletableFutureMessageSender {
    val messages = mutableListOf<String>()

    override fun sendMessage(msg: String): CompletableFuture<String> {
        messages += msg
        return CompletableFuture.completedFuture("sent: $msg")
    }
}