package dev.boecker.cherrycave.backend.rest

import io.ktor.server.routing.Routing
import io.ktor.server.routing.get
import io.ktor.server.routing.route

fun Routing.playerRoute() = route("/player") {
    get("game-data") {

    }
}