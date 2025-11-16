package com.randomuser.data.local.dao

import androidx.room.*
import com.randomuser.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(users: List<UserEntity>)

    @Query("SELECT * FROM users")
    fun getAllUsers(): Flow<List<UserEntity>>

    @Query("SELECT * FROM users WHERE localId = :id")
    suspend fun getUserById(id: Int): UserEntity?

    @Query("DELETE FROM users WHERE localId = :id")
    suspend fun deleteUser(id: Int)
}