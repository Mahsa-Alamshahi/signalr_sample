package com.gatepay.signalr_sample.domain.usecase

import com.gatepay.signalr_sample.common.Resource
import com.gatepay.signalr_sample.data.data_source.remote.dto.LoginAndRegisterRequest
import com.gatepay.signalr_sample.data.data_source.remote.dto.MultiLoginResponse
import com.gatepay.signalr_sample.domain.repository.LoginAndRegisterRepository
import javax.inject.Inject

class MultiLoginUseCase @Inject constructor(private val loginAndRegisterRepository: LoginAndRegisterRepository) {


    suspend operator fun invoke(request: LoginAndRegisterRequest): Resource<MultiLoginResponse> =
        loginAndRegisterRepository.multiLogin(request)

}