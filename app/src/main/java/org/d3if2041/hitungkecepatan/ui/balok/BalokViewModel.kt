package org.d3if2041.hitungkecepatan.ui.balok

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if2041.hitungkecepatan.db.BalokDao
import org.d3if2041.hitungkecepatan.db.BalokEntity
import org.d3if2041.hitungkecepatan.model.HasilBalok

class BalokViewModel(private val db: BalokDao): ViewModel() {

    private val hasilBalok = MutableLiveData<HasilBalok?>()

    val data = db.getLastBalok()

    fun hitungVolumeBalok(panjang: Float, lebar: Float, tinggi: Float) {
        val volume = panjang * lebar * tinggi
        hasilBalok.value = HasilBalok(volume)

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val dataBalok = BalokEntity(
                    panjang = panjang,
                    lebar = lebar,
                    tinggi = tinggi
                )
                db.insert(dataBalok)
            }
        }
    }

    fun getHasilBalok(): LiveData<HasilBalok?> = hasilBalok
}