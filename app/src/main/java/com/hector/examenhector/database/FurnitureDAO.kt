package com.hector.examenhector.database
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hector.examenhector.model.Moble

@Dao
interface FurnitureDAO {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertFurniture(moble: Moble)

    @Query("SELECT * FROM Furniture")
    fun initialFurnitureQuery(): LiveData<List<Moble>>?
}