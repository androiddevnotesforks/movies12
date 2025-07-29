import com.android.build.api.variant.BuildConfigField
import java.io.StringReader
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
    namespace = "ru.resodostudio.flick.core.common"
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    api(projects.core.common)
    api(projects.core.model)

    implementation(libs.kotlinx.serialization.json)
    implementation(platform(libs.ktor.bom))
    implementation(libs.ktor.client.auth)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.client.okhttp)
    implementation(libs.ktor.serialization.kotlinx.json)
}

val apiUrl = providers.fileContents(
    isolated.rootProject.projectDirectory.file("local.properties")
).asText.map { text ->
    val properties = Properties()
    properties.load(StringReader(text))
    properties["API_URL"] as String?
}.orElse("123")

val apiKey = providers.fileContents(
    isolated.rootProject.projectDirectory.file("local.properties")
).asText.map { text ->
    val properties = Properties()
    properties.load(StringReader(text))
    properties["API_KEY"] as String?
}.orElse("123")

androidComponents {
    onVariants {
        it.buildConfigFields?.put("API_URL", apiUrl.map { value ->
            BuildConfigField(type = "String", value = """"$value"""", comment = null)
        })
        it.buildConfigFields?.put("API_KEY", apiKey.map { value ->
            BuildConfigField(type = "String", value = """"$value"""", comment = null)
        })
    }
}