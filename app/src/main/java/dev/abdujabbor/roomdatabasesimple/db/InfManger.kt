package dev.abdujabbor.roomdatabasesimple.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import dev.abdujabbor.roomdatabasesimple.models.Manager

@Dao
interface InfManger {
    @Insert
    fun addManager(manger: Manager)

    @Query("select * from Manager")
    fun getAllManager():List<Manager>
}