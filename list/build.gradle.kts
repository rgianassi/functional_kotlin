plugins {
    id("functional_kotlin.kotlin-library-conventions")
    id("org.jetbrains.dokka") version "1.7.0" apply true
}

repositories {
    mavenCentral()
}

tasks.dokkaHtmlPartial.configure {
    failOnWarning.set(true)

    // dokkaSourceSets {
    // configureEach {
    // includes.from("Module.md")
    // }
    // }
}
