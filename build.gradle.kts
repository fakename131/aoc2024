plugins {
    kotlin("jvm") version "2.0.21"
}

group = "dev.fake"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
}

kotlin {
    jvmToolchain(18)
}