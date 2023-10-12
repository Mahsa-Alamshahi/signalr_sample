package com.gatepay.signalr_sample.domain.repository

import com.gatepay.signalr_sample.data.data_source.local.LoginEntity

interface DatabaseRepository {

    suspend fun addUser(loginEntity: LoginEntity)
    suspend fun isUserExisted(): Boolean
    suspend fun getUser(): List<LoginEntity>
}