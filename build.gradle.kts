plugins {
    id("com.diffplug.spotless") version "6.8.0" apply true
    // id("org.cqfn.diktat.diktat-gradle-plugin") version "1.2.1" apply true
}

repositories {
    // Use the plugin portal to apply community plugins in convention plugins.
    gradlePluginPortal()
}

spotless {
    format("misc") {
        target(".md", ".gitignore", ".gitattributes", ".yaml", ".yml")
        trimTrailingWhitespace()
        endWithNewline()
    }
    kotlin {
        target("**/*.kt")
        targetExclude("**/build/**")
        ktlint()
        // diktat()
        indentWithSpaces()
        trimTrailingWhitespace()
        endWithNewline()
    }
    kotlinGradle {
        target("**/*.gradle.kts")
        targetExclude("**/build/**")
        // diktat()
    }
}
