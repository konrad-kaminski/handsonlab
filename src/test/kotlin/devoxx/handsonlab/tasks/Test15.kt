package devoxx.handsonlab.tasks

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

/**
 * Tests for [sendMessageWithRequestId].
 */
@Tag("part2")
class Test15: AbstractTest() {
    @Test
    fun `should propagate request id in ThreadLocal`() {
        //given
        requestId.set("req-id")

        //when
        runBlocking {
            sendMessageWithRequestId("ABC")
        }

        //then
        assertEquals(listOf("req-id: ABC"), messages)
    }
}
