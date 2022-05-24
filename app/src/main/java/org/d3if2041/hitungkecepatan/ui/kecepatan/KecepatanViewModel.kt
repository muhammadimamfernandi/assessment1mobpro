package org.d3if2041.hitungkecepatan.ui.kecepatan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if2041.hitungkecepatan.db.KecepatanDao
import org.d3if2041.hitungkecepatan.db.KecepatanEntity
import org.d3if2041.hitungkecepatan.model.HasilKecepatan

class KecepatanViewModel(private val db: KecepatanDao) : ViewModel() {

    private val hasilKecepatan = MutableLiveData<HasilKecepatan?>()

    val data = db.getLastKecepatan()

    fun hitungKecepatan(jarak: Float, waktu: Float) {
        val kecepatan = jarak / waktu
        hasilKecepatan.value = HasilKecepatan(kecepatan)

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val dataKecepatan = KecepatanEntity(
                    jarak = jarak,
                    waktu = waktu
                )
                db.insert(dataKecepatan)
            }
        }
    }

    fun getHasilKecepatan(): LiveData<HasilKecepatan?> = hasilKecepatan

}

