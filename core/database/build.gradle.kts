plugins {
    alias(libs.plugins.flick.android.library)
    alias(libs.plugins.flick.android.room)
    alias(libs.plugins.flick.hilt)
}

android {
    namespace = "ru.resodostudio.flick.core.database"
}

dependencies {
    api(projects.core.model)
}
