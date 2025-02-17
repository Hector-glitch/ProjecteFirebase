package com.hector.projectefirebase.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.hector.projectefirebase.model.Moble
import com.hector.projectefirebase.repository.Repository

class InsertViewModel: ViewModel() {

    fun insertMobles(context: Context, moble: Moble) {
        Repository.insertFurniture(context, moble)
    }

}