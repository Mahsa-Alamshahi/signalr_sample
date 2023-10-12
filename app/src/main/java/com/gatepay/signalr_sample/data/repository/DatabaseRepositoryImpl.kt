package com.gatepay.signalr_sample.data.repository

import com.gatepay.signalr_sample.data.data_source.local.LoginDao
import com.gatepay.signalr_sample.data.data_source.local.LoginEntity
import com.gatepay.signalr_sample.domain.repository.DatabaseRepository
import com.orhanobut.logger.Logger
import javax.inject.Inject

class DatabaseRepositoryImpl @Inject constructor(private val loginDao: LoginDao): DatabaseRepository {
    override suspend fun addUser(loginEntity: LoginEntity) {
        var userList = loginDao.getUser()
        Logger.d(userList.size)
        if (isUserExisted().not()){
            Logger.d(isUserExisted())
            loginDao.addUser(loginEntity)
        } else {
            loginDao.deleteUser()
            loginDao.addUser(loginEntity)
        }
    }

    override suspend fun isUserExisted(): Boolean {
        val userList = loginDao.getUser()
        return userList.isNotEmpty()
    }

    override suspend fun getUser(): List<LoginEntity> {
      return loginDao.getUser()
    }
}