package org.d3if2041.hitungkecepatan.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "kecepatan")
data class KecepatanEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    var jarak: Float,
    var waktu: Float
)
