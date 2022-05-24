package org.d3if2041.hitungkecepatan.ui.histori

import androidx.lifecycle.ViewModel
import org.d3if2041.hitungkecepatan.db.KecepatanDao

class KecepatanHistoriViewModel(db: KecepatanDao) : ViewModel() {
    val data = db.getLastKecepatan()
}