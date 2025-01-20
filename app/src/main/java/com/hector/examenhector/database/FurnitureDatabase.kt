package com.hector.examenhector.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hector.examenhector.model.Moble

@Database(entities = [Moble::class], version = 1, exportSchema = false)
abstract class FurnitureDatabase: RoomDatabase() {

    abstract fun furnitureDAO(): FurnitureDAO
    companion object {
        @Volatile
        private var INSTANCE: FurnitureDatabase? = null

        fun getDatabase(context: Context): FurnitureDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = buildDatabase(context)
                }
            }

            return INSTANCE!!
        }

        fun buildDatabase(context: Context): FurnitureDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                FurnitureDatabase::class.java,
                "alumn_db"
            )
                .createFromAsset("database/furniture.db").build()
        }

    }
}