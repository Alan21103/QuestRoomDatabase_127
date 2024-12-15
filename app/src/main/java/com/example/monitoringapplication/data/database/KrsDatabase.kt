package com.example.monitoringapplication.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.monitoringapplication.data.dao.MahasiswaDao
import com.example.monitoringapplication.data.entity.Mahasiswa
import kotlin.concurrent.Volatile

@Database(entities = [Mahasiswa::class], version = 1, exportSchema = false)
abstract class KrsDatabase: RoomDatabase() {

    //Mendifinisikan fungsi untuk mengakses data Mahasiswa
    abstract fun mahasiswaDao(): MahasiswaDao

    companion object{
        @Volatile // Memastikan bahwa nilai variable instance selalu sama di semua thread
        private var Instance: KrsDatabase? = null

        fun getDatabase(context: Context): KrsDatabase {
            return (Instance ?: synchronized(this){
                Room.databaseBuilder(
                    context,
                    KrsDatabase::class.java, // Class Database
                    "KrsDatabase" // Nama Database
                )
                    .build().also { Instance= it }
            })
        }
    }
}