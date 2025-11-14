package com.example.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.local.dao.UserDao
import com.example.data.local.entity.UserEntity

private const val DATABASE_VERSION = 1

@Database(
    entities = [
        UserEntity::class
    ],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}

fun createDatabase(context: Context) = Room.databaseBuilder(
    context,
    AppDatabase::class.java,
    "randomuser-db"
).fallbackToDestructiveMigration().build()