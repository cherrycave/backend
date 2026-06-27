package dev.boecker.cherrycave.backend

import dev.boecker.ccbackend.db.table.MinecraftPlayers
import dev.boecker.ccbackend.rest.playerRoute
import io.github.oshai.kotlinlogging.KotlinLogging
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.install
import io.ktor.server.cio.CIO
import io.ktor.server.engine.embeddedServer
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.routing.routing
import org.jetbrains.exposed.v1.migration.r2dbc.MigrationUtils
import org.jetbrains.exposed.v1.r2dbc.R2dbcDatabase
import org.jetbrains.exposed.v1.r2dbc.transactions.TransactionManager
import org.jetbrains.exposed.v1.r2dbc.transactions.suspendTransaction

class Backend {

    lateinit var database: R2dbcDatabase

    private val logger = KotlinLogging.logger {}

    suspend fun start() {
        logger.info { "Starting Cherrycave Backend..." }

        val databaseUrl = System.getenv("POSTGRES_URL") ?: "postgresql://localhost:5432/cherrycave"

        database = R2dbcDatabase.connect(
            url = "r2dbc:$databaseUrl",
            driver = "postgresql",
            user = "cherrycave",
        )

        TransactionManager.defaultDatabase = database

        runMigrations()
    }

    private fun startKtorAPI(host: String, port: Int) {
        embeddedServer(CIO, port, host) {
            install(ContentNegotiation) {
                json()
            }

            routing {
                playerRoute()
            }
        }
    }

    private suspend fun runMigrations() {
        logger.info { "Running Migrations..." }

        suspendTransaction {
            val statements = MigrationUtils.statementsRequiredForDatabaseMigration(
                MinecraftPlayers,
            )

            execInBatch(statements)
        }
    }
}