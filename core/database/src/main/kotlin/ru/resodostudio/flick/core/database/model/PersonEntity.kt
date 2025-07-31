package ru.resodostudio.flick.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.resodostudio.flick.core.model.data.Person

@Entity(
    tableName = "people",
)
data class PersonEntity(
    @PrimaryKey
    val id: Int,
    val adult: Boolean,
    val gender: Int,
    val knownForDepartment: String,
    val name: String,
    val originalName: String,
    val popularity: Double,
    val profilePath: String,
)

fun PersonEntity.asExternalModel(): Person {
    return Person(
        adult = adult,
        gender = gender,
        id = id,
        knownForDepartment = knownForDepartment,
        name = name,
        originalName = originalName,
        popularity = popularity,
        profilePath = profilePath,
    )
}