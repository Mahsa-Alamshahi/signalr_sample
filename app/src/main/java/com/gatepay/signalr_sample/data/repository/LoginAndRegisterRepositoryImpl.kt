package com.gatepay.signalr_sample.data.repository

import com.gatepay.signalr_sample.data.data_source.remote.ApiService
import com.gatepay.signalr_sample.data.data_source.remote.dto.LoginAndRegisterRequest
import com.gatepay.signalr_sample.data.data_source.remote.dto.LoginAndRegisterResponse
import com.gatepay.signalr_sample.domain.repository.LoginAndRegisterRepository
import javax.inject.Inject

class LoginAndRegisterRepositoryImpl @Inject constructor(private val apiService: ApiService) : LoginAndRegisterRepository {

    override suspend fun loginAndRegister(request: LoginAndRegisterRequest): LoginAndRegisterResponse {
            return apiService.loginAndRegister(request)
    }
}