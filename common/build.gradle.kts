plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    `maven-publish`
}

group = "dev.boecker.cherrycave"
version = rootProject.version

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.11.0")
}

kotlin {
    jvmToolchain(25)
}

publishing {
    repositories {
        maven {
            setUrl("https://maven.boecker.dev/releases")

            credentials {
                username = System.getenv("MAVEN_USERNAME")
                password = System.getenv("MAVEN_SECRET")
            }
        }
    }

    publications {
        publications {
            create<MavenPublication>(project.name) {
                from(components["kotlin"])
                pom {
                    name.set(project.name)
                    description.set("common types for the minecraft server backend")
                    url.set("https://github.com/cherrycave/backend")

                    licenses {
                        license {
                            name.set("AGPL-3.0 License")
                            url.set("https://github.com/cherrycave/backend/LICENSE")
                        }
                    }

                    developers {
                        developer {
                            name.set("Lou Emma Böcker")
                            email.set("lou@boecker.dev")
                            organizationUrl.set("https://www.boecker.dev")
                        }
                    }
                }
            }
        }
    }
}