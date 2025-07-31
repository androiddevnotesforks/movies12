package ru.resodostudio.core.data.model

import ru.resodostudio.flick.core.database.model.PersonEntity
import ru.resodostudio.flick.core.network.model.NetworkPerson

fun NetworkPerson.asEntity(): PersonEntity {
    return PersonEntity(
        id = id ?: -1,
        adult = adult ?: false,
        gender = gender ?: -1,
        knownForDepartment = knownForDepartment ?: "",
        name = name ?: "",
        originalName = originalName ?: "",
        popularity = popularity ?: 0.0,
        profilePath = profilePath ?: "",
    )
}