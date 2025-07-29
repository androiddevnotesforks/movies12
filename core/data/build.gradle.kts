plugins {
    alias(libs.plugins.flick.android.library)
    alias(libs.plugins.flick.hilt)
}

android {
    namespace = "ru.resodostudio.core.data"
}

dependencies {
    api(projects.core.common)
    api(projects.core.database)
    api(projects.core.datastore)
    api(projects.core.network)
}