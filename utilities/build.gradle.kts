plugins {
    id("functional_kotlin.kotlin-library-conventions")
    id("org.jetbrains.dokka") version "1.7.0" apply true
}

repositories {
    mavenCentral()
}

dependencies {
    api(project(":list"))
}

tasks.dokkaHtmlPartial.configure {
    failOnWarning.set(true)

    // dokkaSourceSets {
    // configureEach {
    // includes.from("Module.md")
    // }
    // }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}
