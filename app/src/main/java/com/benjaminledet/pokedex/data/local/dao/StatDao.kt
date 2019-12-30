package com.benjaminledet.pokedex.data.local.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.benjaminledet.pokedex.data.model.Stat

@Dao
abstract class StatDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(data: List<Stat>): List<Long>

    @Delete
    abstract suspend fun delete(data: List<Stat>)

    @Query("DELETE FROM ${Stat.TABLE_NAME}")
    abstract suspend fun deleteAll()

    @Query("SELECT * FROM ${Stat.TABLE_NAME} WHERE ${Stat.ID} = :id")
    abstract suspend fun getById(id: Int?): Stat?

    @Query("SELECT * FROM ${Stat.TABLE_NAME} WHERE ${Stat.ID} = :id")
    abstract fun getByIdObservable(id: Int?): LiveData<Stat?>

    @Query("SELECT * FROM ${Stat.TABLE_NAME}")
    abstract suspend fun getAll(): List<Stat>

    @Query("SELECT * FROM ${Stat.TABLE_NAME}")
    abstract fun getAllObservable(): LiveData<List<Stat>>

    @Query("SELECT * FROM ${Stat.TABLE_NAME} WHERE ${Stat.NAME} in (:names)")
    abstract fun getAllObservable(names: List<String>): LiveData<List<Stat>>

    @Query("SELECT * FROM ${Stat.TABLE_NAME}")
    abstract fun getAllPaged(): DataSource.Factory<Int, Stat>
}