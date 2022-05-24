package org.d3if2041.hitungkecepatan.model

import org.d3if2041.hitungkecepatan.db.BalokEntity

fun BalokEntity.hitungBalok(): HasilBalok {
    val volume = panjang * lebar * tinggi
    return HasilBalok(volume)
}