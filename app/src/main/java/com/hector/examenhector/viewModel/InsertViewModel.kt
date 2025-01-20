package com.hector.examenhector.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.hector.examenhector.model.Moble
import com.hector.examenhector.repository.Repository

class InsertViewModel: ViewModel() {

    fun insertMobles(context: Context, moble: Moble) {
        Repository.insertAlumn(context, moble)
    }
}