package com.gatepay.signalr_sample.domain.usecase

import com.gatepay.signalr_sample.domain.repository.DatabaseRepository
import com.orhanobut.logger.Logger
import javax.inject.Inject

class CheckUserExistanceUseCase @Inject constructor(private val databaseRepository: DatabaseRepository) {

    suspend operator fun invoke(): Boolean {
        var isExist = databaseRepository.isUserExisted()
        Logger.d(isExist)
        return isExist
    }
}