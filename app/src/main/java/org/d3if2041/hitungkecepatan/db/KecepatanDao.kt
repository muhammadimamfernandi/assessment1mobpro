package org.d3if2041.hitungkecepatan.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface KecepatanDao {

    @Insert
    fun insert(kecepatan: KecepatanEntity)

    @Query("SELECT * FROM kecepatan ORDER BY id DESC LIMIT 1")
    fun getLastKecepatan(): LiveData<KecepatanEntity?>
}