plugins {
    application
    kotlin("jvm")
    id("io.ktor.plugin") version "3.5.0"
}

group = "dev.boecker.cherrycave"
version = rootProject.version

repositories {
    mavenCentral()
}

dependencies {
    implementation("dev.kourier:amqp-client-robust:0.4.6")

    implementation("org.jetbrains.exposed:exposed-core:1.3.0")
    implementation("org.jetbrains.exposed:exposed-r2dbc:1.3.0")
    implementation("org.jetbrains.exposed:exposed-kotlin-datetime:1.3.0")
    implementation("org.jetbrains.exposed:exposed-migration-core:1.3.0")
    implementation("org.jetbrains.exposed:exposed-migration-r2dbc:1.3.0")
    implementation("org.postgresql:r2dbc-postgresql:1.1.1.RELEASE")

    implementation("io.ktor:ktor-server-core")
    implementation("io.ktor:ktor-server-cio")
    implementation("io.ktor:ktor-server-content-negotiation")
    implementation("io.ktor:ktor-serialization-kotlinx-json")


    implementation("ch.qos.logback:logback-classic:1.5.34")
    implementation("io.github.oshai:kotlin-logging-jvm:8.0.4")
}

application {
    mainClass.set("dev.boecker.ccbackend.LauncherKt")
}