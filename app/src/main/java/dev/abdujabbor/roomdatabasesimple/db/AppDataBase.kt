package dev.abdujabbor.roomdatabasesimple.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.abdujabbor.roomdatabasesimple.models.Manager


@Database(entities = [Manager::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun myDao(): InfManger

    companion object {
        private var instace: AppDataBase? = null

        @Synchronized
        fun getInstance(context: Context): AppDataBase {

            if (instace == null) {
                instace = Room.databaseBuilder(context, AppDataBase::class.java, "news    ")
                    .fallbackToDestructiveMigration().allowMainThreadQueries().build()
            }
            return instace!!

        }
    }
}