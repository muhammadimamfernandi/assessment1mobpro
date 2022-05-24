package org.d3if2041.hitungkecepatan.ui.histori

import androidx.lifecycle.ViewModel
import org.d3if2041.hitungkecepatan.db.BalokDao

class BalokHistoriViewModel(db: BalokDao) : ViewModel() {
    val data = db.getLastBalok()
}