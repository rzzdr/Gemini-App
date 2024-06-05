package com.rudrpsingh.gemini.chat

import java.util.UUID
data class ChatMessage(
    val id: String = UUID.randomUUID().toString(),
    var text: String = "",
    val participant: Participant = Participant.ME,
    var isPending: Boolean = false
)