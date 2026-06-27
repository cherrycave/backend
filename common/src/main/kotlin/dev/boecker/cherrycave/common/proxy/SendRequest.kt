package dev.boecker.cherrycave.common.proxy

import dev.boecker.cherrycave.common.serializer.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class SendRequest(
    @Serializable(with = UUIDSerializer::class)
    val player: UUID,
    val toServer: String,
)
