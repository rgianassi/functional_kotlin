plugins {
    id("com.diffplug.spotless") version "6.8.0" apply true
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
        ktlint()
        //diktat()
        prettier()
        indentWithSpaces()
        trimTrailingWhitespace()
        endWithNewline()
    }
    kotlinGradle {
        target("**/*.gradle.kts")
        //diktat()
    }
}
