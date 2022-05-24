package org.d3if2041.hitungkecepatan.ui.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if2041.hitungkecepatan.db.BalokDao

class BalokHistoriViewModelFactory(
    private val db: BalokDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BalokHistoriViewModel::class.java)) {
            return BalokHistoriViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}