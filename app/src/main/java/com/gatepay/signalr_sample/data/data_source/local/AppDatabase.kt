package com.gatepay.signalr_sample.data.data_source.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [LoginEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun loginDao(): LoginDao
}