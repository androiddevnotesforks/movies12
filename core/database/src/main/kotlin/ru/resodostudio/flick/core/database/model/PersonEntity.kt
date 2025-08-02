package ru.resodostudio.flick.core.database.model

import androidx.room.ColumnInfo
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
    @ColumnInfo(name = "known_for_department")
    val knownForDepartment: String,
    val name: String,
    @ColumnInfo(name = "original_name")
    val originalName: String,
    val popularity: Double,
    @ColumnInfo(name = "profile_path")
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