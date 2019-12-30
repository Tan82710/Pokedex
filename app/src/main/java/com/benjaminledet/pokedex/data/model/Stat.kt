package com.benjaminledet.pokedex.data.model


import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.benjaminledet.pokedex.data.remote.response.ApiResourceResponse


@Entity(tableName = Stat.TABLE_NAME)
data class Stat(

    @PrimaryKey
    @ColumnInfo(name = ID)
    val id: Int,

    @ColumnInfo(name = NAME)
    val name: String,

    @ColumnInfo(name = GAME_INDEX)
    val game_index: Int
) {

    override fun toString(): String = name

    companion object {

        const val TABLE_NAME = "Stat"
        const val ID = "id"
        const val NAME = "name"
        const val GAME_INDEX = "game_index"

    }
}