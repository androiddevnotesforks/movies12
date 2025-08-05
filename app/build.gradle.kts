import ru.resodostudio.flick.FlickBuildType

plugins {
    alias(libs.plugins.flick.android.application)
    alias(libs.plugins.flick.android.application.compose)
    alias(libs.plugins.flick.android.application.firebase)
    alias(libs.plugins.flick.hilt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    defaultConfig {
        applicationId = "ru.resodostudio.flick"
        versionCode = 1
        versionName = "2.0.0"

        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        debug {
            applicationIdSuffix = FlickBuildType.DEBUG.applicationIdSuffix
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            applicationIdSuffix = FlickBuildType.RELEASE.applicationIdSuffix
            signingConfig = signingConfigs.named("debug").get()
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    androidResources {
        generateLocaleConfig = true
    }
    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
    namespace = "ru.resodostudio.flick"
}

dependencies {
    implementation(projects.feature.tvShows)
    implementation(projects.feature.home)
    implementation(projects.feature.movies)
    implementation(projects.feature.people)
    implementation(projects.feature.movie)
    implementation(projects.feature.person)
    implementation(projects.feature.settings)

    implementation(projects.core.data)
    implementation(projects.core.designsystem)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3.adaptive)
    implementation(libs.androidx.compose.material3.adaptive.navigation)
    implementation(libs.androidx.compose.material3.adaptive.navigation.suite)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.hilt.lifecycle.viewmodel.compose)
    implementation(libs.androidx.tracing)
}