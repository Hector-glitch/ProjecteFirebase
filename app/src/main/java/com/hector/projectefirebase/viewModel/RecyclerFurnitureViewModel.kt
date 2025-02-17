package com.hector.projectefirebase.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.hector.projectefirebase.model.Moble
import com.hector.projectefirebase.repository.Repository

class RecyclerFurnitureViewModel: ViewModel() {

    lateinit var mobles: LiveData<List<Moble>>

    fun getAllFurniture(context: Context) {
        mobles = Repository.getAllFurniture(context)!!
    }
}