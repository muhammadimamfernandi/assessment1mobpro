package org.d3if2041.hitungkecepatan.ui.kecepatan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if2041.hitungkecepatan.db.KecepatanDao
import java.lang.IllegalArgumentException

class KecepatanViewModelFactory(
    private val db: KecepatanDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(KecepatanViewModel::class.java)) {
            return KecepatanViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}