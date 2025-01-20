package com.hector.examenhector.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hector.examenhector.model.Moble
import com.hector.examenhector.repository.Repository

class RecyclerFurnitureViewModel: ViewModel() {

    lateinit var mobles: LiveData<List<Moble>>

    fun getAllFurniture(context: Context) {
        mobles = Repository.getAllFurniture(context)!!
    }
}