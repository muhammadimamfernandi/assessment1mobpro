package org.d3if2041.hitungkecepatan.ui.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if2041.hitungkecepatan.db.KecepatanDao

class KecepatanHistoriViewModelFactory(
    private val db: KecepatanDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(KecepatanHistoriViewModel::class.java)) {
            return KecepatanHistoriViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}