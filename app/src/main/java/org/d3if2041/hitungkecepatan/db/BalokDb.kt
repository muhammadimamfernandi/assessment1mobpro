package org.d3if2041.hitungkecepatan.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BalokEntity::class], version = 1, exportSchema = false)
abstract class BalokDb : RoomDatabase() {

    abstract val dao : BalokDao

    companion object {

        @Volatile
        private var INSTANCE: BalokDb? = null

        fun getInstance(context: Context): BalokDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        BalokDb::class.java,
                        "balok.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}