package com.gatepay.signalr_sample.data.data_source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LoginDao {

    @Query("Select * from login")
    suspend fun getUser(): List<LoginEntity>

    @Insert
    suspend fun addUser(loginEntity: LoginEntity)


    @Query("Delete from login")
    suspend fun deleteUser()
}