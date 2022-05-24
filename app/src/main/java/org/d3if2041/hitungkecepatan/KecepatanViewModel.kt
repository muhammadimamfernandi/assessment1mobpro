package org.d3if2041.hitungkecepatan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if2041.hitungkecepatan.model.HasilKecepatan

class KecepatanViewModel : ViewModel() {

    private val hasilKecepatan = MutableLiveData<HasilKecepatan?>()

    fun hitungKecepatan(jarak: Float, waktu: Float) {
        val kecepatan = jarak / waktu
        hasilKecepatan.value = HasilKecepatan(kecepatan)
    }

    fun getHasilKecepatan(): LiveData<HasilKecepatan?> = hasilKecepatan

}

