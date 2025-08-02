package ru.resodostudio.flick.core.database.util

import androidx.room.TypeConverter

internal class ListIntConverter {

    @TypeConverter
    fun listToString(list: List<Int>): String {
        return list.joinToString(", ")
    }

    @TypeConverter
    fun stringToList(value: String): List<Int> {
        return value.split(", ").map { it.toInt() }
    }
}
