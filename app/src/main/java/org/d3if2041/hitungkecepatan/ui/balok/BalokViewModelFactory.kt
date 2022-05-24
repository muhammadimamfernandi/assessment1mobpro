package org.d3if2041.hitungkecepatan.ui.balok

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if2041.hitungkecepatan.db.BalokDao
import java.lang.IllegalArgumentException

class BalokViewModelFactory(
    private val db: BalokDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BalokViewModel::class.java)) {
            return BalokViewModel(db) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}