package org.d3if2041.hitungkecepatan.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "balok")
data class BalokEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    var panjang: Float,
    var lebar: Float,
    var tinggi: Float
)
