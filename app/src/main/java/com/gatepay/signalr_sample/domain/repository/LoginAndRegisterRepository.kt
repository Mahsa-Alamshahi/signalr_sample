package com.gatepay.signalr_sample.domain.repository

import com.gatepay.signalr_sample.common.Resource
import com.gatepay.signalr_sample.data.data_source.remote.dto.LoginAndRegisterRequest
import com.gatepay.signalr_sample.data.data_source.remote.dto.LoginAndRegisterResponse

interface LoginAndRegisterRepository {

    suspend fun loginAndRegister(request: LoginAndRegisterRequest): LoginAndRegisterResponse
}