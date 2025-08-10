plugins {
    alias(libs.plugins.flick.android.library)
    alias(libs.plugins.flick.android.library.compose)
}

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    namespace = "ru.resodostudio.flick.core.ui"
}

dependencies {
    api(projects.core.designsystem)
    api(projects.core.model)
    api(projects.core.locales)

    implementation(platform(libs.coil.bom))
    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)
    implementation(libs.lottie.compose)
}
