package devoxx.handsonlab.tasks

import org.junit.jupiter.api.BeforeEach
import java.util.concurrent.CountDownLatch

abstract class AbstractTest {
    private val onMessageHandlers = mutableListOf<suspend (String) -> Unit>()

    val messages = mutableListOf<String>()

    var sendMessageLatch: CountDownLatch = CountDownLatch(1)

    @BeforeEach
    fun init() {
        onSendMessage = { message ->
            onMessageHandlers.forEach { handler ->
                handler.invoke(message)
            }

            synchronized(this) {
                messages += message
                sendMessageLatch.countDown()
            }
        }
    }

    fun addOnMessageHandler(handler: suspend (String) -> Unit) {
        onMessageHandlers += handler
    }
}