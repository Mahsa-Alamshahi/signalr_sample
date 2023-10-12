package com.gatepay.signalr_sample.domain.usecase

import com.gatepay.signalr_sample.data.data_source.remote.dto.RecordResponse
import com.gatepay.signalr_sample.data.data_source.remote.dto.toLoginEntity
import com.gatepay.signalr_sample.domain.repository.DatabaseRepository
import javax.inject.Inject

class AddUserIntoDBUseCase @Inject constructor(private val databaseRepository: DatabaseRepository) {

    suspend operator fun invoke(
        recordResponse: RecordResponse,
        password: String
    ){
      databaseRepository.addUser(recordResponse.toLoginEntity(password))
    }
}