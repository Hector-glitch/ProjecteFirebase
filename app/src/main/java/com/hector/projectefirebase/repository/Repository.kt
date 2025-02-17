package com.hector.projectefirebase.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.hector.projectefirebase.database.FurnitureDatabase
import com.hector.projectefirebase.model.Moble
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repository {
    companion object {
        var furnitureDatabase: FurnitureDatabase? = null
        var mobles : LiveData<List<Moble>>? = null

        fun initializeDB(context: Context): FurnitureDatabase {
            return FurnitureDatabase.getDatabase(context)
        }

        fun insertFurniture(context: Context, moble: Moble) {
            furnitureDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                furnitureDatabase!!.furnitureDAO().insertFurniture(moble)
            }
        }

        fun getAllFurniture(context: Context): LiveData<List<Moble>>? {
            furnitureDatabase = initializeDB(context)

            mobles = furnitureDatabase!!.furnitureDAO().initialFurnitureQuery()
            return mobles
        }

    }
}