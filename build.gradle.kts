import org.jetbrains.compose.compose

plugins {
    kotlin("jvm") version "1.5.21"
    id("org.jetbrains.compose") version "0.5.0-build262"
}

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(compose.desktop.currentOs)
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.5.30-M1")

}


compose.desktop {
    application {
        mainClass = "MainKt"
    }
}