package com.benjaminledet.pokedex.data.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Characteristic.TABLE_NAME)
data class Characteristic(

    @PrimaryKey
    @ColumnInfo(name = ID)
    val id: Int,

    @ColumnInfo(name = DESCRIPTIONS)
    val descriptions: String
) {

    companion object {

        const val TABLE_NAME = "Characteristic"
        const val ID = "id"
        const val DESCRIPTIONS = "descriptions"
    }
}