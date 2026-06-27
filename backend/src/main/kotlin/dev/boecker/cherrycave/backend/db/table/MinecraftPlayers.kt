package dev.boecker.cherrycave.backend.db.table

import org.jetbrains.exposed.v1.core.Table
import org.jetbrains.exposed.v1.datetime.datetime
import kotlin.uuid.ExperimentalUuidApi

object MinecraftPlayers : Table("players") {
    @OptIn(ExperimentalUuidApi::class)
    val uuid = uuid("uuid")
    val lastKnownUsername = varchar("username", 32)
    val firstJoin = datetime("first_join")
    val lastJoin = datetime("last_join")

    @OptIn(ExperimentalUuidApi::class)
    override val primaryKey = PrimaryKey(uuid)
}