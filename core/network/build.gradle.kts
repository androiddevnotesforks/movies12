import java.util.Properties

plugins {
    alias(libs.plugins.flick.android.library)
    alias(libs.plugins.flick.hilt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    buildFeatures {
        buildConfig = true
    }
    defaultConfig {
        val localPropertiesFile = rootProject.file("local.properties")
        val localProperties = Properties()
        localProperties.load(localPropertiesFile.inputStream())

        val apiUrl = localProperties.getProperty("API_URL")
        val apiKey = localProperties.getProperty("API_KEY")

        buildConfigField("String", "API_URL", "\"$apiUrl\"")
        buildConfigField("String", "API_KEY", "\"$apiKey\"")
    }
    namespace = "ru.resodostudio.flick.core.network"
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.model)

    implementation(libs.coil.kt.compose)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.retrofit)
    implementation(libs.okhttp)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(platform(libs.ktor.bom))
    implementation(libs.ktor.client.auth)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.client.okhttp)
    implementation(libs.ktor.serialization.kotlinx.json)
}
