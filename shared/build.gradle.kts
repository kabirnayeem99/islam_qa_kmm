plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class) kotlin {
    jvmToolchain(17)
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }

    listOf(
        iosX64(), iosArm64(), iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                // Multiplatform dependencies

                // Skrape.it - for web scraping
//                implementation(Skrap)
//                implementation("it.skrape:skrapeit:1.2.2")
                implementation("com.benasher44:uuid:0.7.1")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    namespace = "io.github.kabirnayeem99.islamqakmm"
    compileSdk = 34
    defaultConfig {
        minSdk = 27
    }
}