package org.d3if2041.hitungkecepatan.model

import org.d3if2041.hitungkecepatan.db.KecepatanEntity

fun KecepatanEntity.hitungKecepatan(): HasilKecepatan {
    val kecepatan = jarak / waktu
    return HasilKecepatan(kecepatan)
}