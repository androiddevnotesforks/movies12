package ru.resodostudios.flick.core.network.model

import kotlinx.serialization.Serializable
import ru.resodostudios.flick.feature.people.domain.model.Person

@Serializable
data class Cast(
    val character: Character? = Character(),
    val person: Person? = Person()
)