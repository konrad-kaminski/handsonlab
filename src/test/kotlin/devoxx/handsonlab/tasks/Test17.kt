package devoxx.handsonlab.tasks

import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import java.util.concurrent.TimeUnit

/**
 * Tests for [sendMessagesWithExceptionHandler].
 */
@Tag("part2")
class Test17: AbstractTest() {
    @Test
    fun `should handle global scope exceptions`() {
        //given
        addOnMessageHandler {
            throw TestException
        }

        //when
        lateinit var e: Throwable
        sendMessagesWithExceptionHandler("ABC") { exception ->
            e = exception
        }
        sendMessageLatch.await(1, TimeUnit.SECONDS)

        //then
        assertSame(TestException, e)
    }
}

private object TestException: Exception("test")