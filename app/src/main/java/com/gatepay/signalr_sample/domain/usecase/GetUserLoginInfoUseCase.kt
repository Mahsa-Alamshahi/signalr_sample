package com.gatepay.signalr_sample.domain.usecase

import com.gatepay.signalr_sample.data.data_source.local.LoginEntity
import com.gatepay.signalr_sample.domain.repository.DatabaseRepository
import com.orhanobut.logger.Logger
import javax.inject.Inject

class GetUserLoginInfoUseCase @Inject constructor(private val databaseRepository: DatabaseRepository) {

    suspend operator fun invoke(): List<LoginEntity> {

        return databaseRepository.getUser()
    }
}