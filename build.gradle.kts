plugins {
    kotlin("jvm") version "2.3.21"
    kotlin("plugin.serialization") version "2.4.0"
}

group = "dev.boecker"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
}

kotlin {
    jvmToolchain(25)
}