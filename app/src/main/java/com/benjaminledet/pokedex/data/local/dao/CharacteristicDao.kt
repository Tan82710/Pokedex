package com.benjaminledet.pokedex.data.local.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.benjaminledet.pokedex.data.model.Characteristic


@Dao
abstract class CharacteristicDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(data: List<Characteristic>): List<Long>

    @Delete
    abstract suspend fun delete(data: List<Characteristic>)

    @Query("DELETE FROM ${Characteristic.TABLE_NAME}")
    abstract suspend fun deleteAll()

    @Query("SELECT * FROM ${Characteristic.TABLE_NAME} WHERE ${Characteristic.ID} = :id")
    abstract suspend fun getById(id: Int?): Characteristic?

    @Query("SELECT * FROM ${Characteristic.TABLE_NAME} WHERE ${Characteristic.ID} = :id")
    abstract fun getByIdObservable(id: Int?): LiveData<Characteristic?>

    @Query("SELECT * FROM ${Characteristic.TABLE_NAME}")
    abstract suspend fun getAll(): List<Characteristic>

    @Query("SELECT * FROM ${Characteristic.TABLE_NAME} WHERE ${Characteristic.DESCRIPTIONS} in (:characteristic)")
    abstract fun getAllObservable(characteristic: List<String>): LiveData<List<Characteristic>>

    @Query("SELECT * FROM ${Characteristic.TABLE_NAME}")
    abstract fun getAllPaged(): DataSource.Factory<Int, Characteristic>
}