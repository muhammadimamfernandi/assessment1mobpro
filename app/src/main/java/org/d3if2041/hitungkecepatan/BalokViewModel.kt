package org.d3if2041.hitungkecepatan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.d3if2041.hitungkecepatan.model.HasilBalok

class BalokViewModel: ViewModel() {

    private val hasilBalok = MutableLiveData<HasilBalok?>()

    fun hitungVolumeBalok(panjang: Float, lebar: Float, tinggi: Float) {
        val volume = panjang * lebar * tinggi
        hasilBalok.value = HasilBalok(volume)
    }

    fun getHasilBalok(): LiveData<HasilBalok?> = hasilBalok
}