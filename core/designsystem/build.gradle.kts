plugins {
    alias(libs.plugins.flick.android.library)
    alias(libs.plugins.flick.android.library.compose)
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    namespace = "ru.resodostudios.flick.core.designsystem"
}

dependencies {
    api(libs.androidx.compose.material.iconsExtended)
    api(libs.androidx.compose.material3)
    //api(libs.androidx.compose.runtime)
    //api(libs.androidx.compose.ui.tooling.preview)
    //api(libs.androidx.compose.ui.util)

    //debugApi(libs.androidx.compose.ui.tooling)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.ui.text.google.fonts)
    implementation(libs.coil.kt.compose)
}