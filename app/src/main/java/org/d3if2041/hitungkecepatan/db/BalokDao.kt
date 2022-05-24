package org.d3if2041.hitungkecepatan.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BalokDao {

    @Insert
    fun insert(balok: BalokEntity)

    @Query("SELECT * FROM balok ORDER BY id LIMIT 1")
    fun getLastBalok(): LiveData<BalokEntity?>
}