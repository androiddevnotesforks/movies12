package ru.resodostudio.datastore

import androidx.datastore.core.DataStore
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import ru.resodostudio.flick.core.model.DarkThemeConfig
import ru.resodostudio.flick.core.model.DarkThemeConfig.DARK
import ru.resodostudio.flick.core.model.DarkThemeConfig.FOLLOW_SYSTEM
import ru.resodostudio.flick.core.model.DarkThemeConfig.LIGHT
import ru.resodostudio.flick.core.model.UserData
import ru.resodostudios.flick.core.datastore.DarkThemeConfigProto.DARK_THEME_CONFIG_DARK
import ru.resodostudios.flick.core.datastore.DarkThemeConfigProto.DARK_THEME_CONFIG_FOLLOW_SYSTEM
import ru.resodostudios.flick.core.datastore.DarkThemeConfigProto.DARK_THEME_CONFIG_LIGHT
import ru.resodostudios.flick.core.datastore.DarkThemeConfigProto.DARK_THEME_CONFIG_UNSPECIFIED
import ru.resodostudios.flick.core.datastore.DarkThemeConfigProto.UNRECOGNIZED
import ru.resodostudios.flick.core.datastore.UserPreferences
import ru.resodostudios.flick.core.datastore.copy
import javax.inject.Inject

class FlickPreferencesDataSource @Inject constructor(
    private val userPreferences: DataStore<UserPreferences>,
) {
    val userData = userPreferences.data
        .map {
            UserData(
                darkThemeConfig = when (it.darkThemeConfig) {
                    null,
                    DARK_THEME_CONFIG_UNSPECIFIED,
                    UNRECOGNIZED,
                    DARK_THEME_CONFIG_FOLLOW_SYSTEM,
                        -> FOLLOW_SYSTEM

                    DARK_THEME_CONFIG_LIGHT -> LIGHT
                    DARK_THEME_CONFIG_DARK -> DARK
                },
                useDynamicColor = it.useDynamicColor,
                sessionId = it.sessionId,
            )
        }
        .catch { UserPreferences.getDefaultInstance() }

    suspend fun setDynamicColorPreference(useDynamicColor: Boolean) {
        runCatching {
            userPreferences.updateData {
                it.copy {
                    this.useDynamicColor = useDynamicColor
                }
            }
        }
    }

    suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig) {
        runCatching {
            userPreferences.updateData {
                it.copy {
                    this.darkThemeConfig = when (darkThemeConfig) {
                        FOLLOW_SYSTEM -> DARK_THEME_CONFIG_FOLLOW_SYSTEM
                        LIGHT -> DARK_THEME_CONFIG_LIGHT
                        DARK -> DARK_THEME_CONFIG_DARK
                    }
                }
            }
        }
    }

    suspend fun updateSessionId(sessionId: String) {
        runCatching {
            userPreferences.updateData {
                it.copy {
                    this.sessionId = sessionId
                }
            }
        }
    }
}