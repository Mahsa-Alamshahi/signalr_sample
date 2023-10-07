package com.gatepay.signalr_sample.domain.usecase

import com.gatepay.signalr_sample.common.Resource
import com.gatepay.signalr_sample.data.data_source.remote.dto.LoginAndRegisterRequest
import com.gatepay.signalr_sample.data.data_source.remote.dto.LoginAndRegisterResponse
import com.gatepay.signalr_sample.domain.repository.LoginAndRegisterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LoginAndRegisterUseCase @Inject constructor(private val repository: LoginAndRegisterRepository) {

    suspend operator fun invoke(request: LoginAndRegisterRequest): LoginAndRegisterResponse {
        return repository.loginAndRegister(request)
    }


}