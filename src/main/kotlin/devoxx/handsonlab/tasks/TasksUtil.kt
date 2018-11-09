package devoxx.handsonlab.tasks

var onSendMessage: suspend (msg: String) -> Unit = {}

suspend fun sendMessage(msg: String): Unit = onSendMessage(msg)

suspend fun sendMessageAck(msg: String): String {
    sendMessage(msg)
    return "sent: $msg"
}
