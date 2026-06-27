package dev.boecker.cherrycave.backend.db.table

import org.jetbrains.exposed.v1.core.Table
import kotlin.uuid.ExperimentalUuidApi

object PlayerGameData : Table("players") {
    val id = integer("id").autoIncrement()
    @OptIn(ExperimentalUuidApi::class)
    val player = reference("uuid", MinecraftPlayers.uuid)
    val gameId = varchar("game_id", 255)
    val data = text("data")

    override val primaryKey = PrimaryKey(id)
}