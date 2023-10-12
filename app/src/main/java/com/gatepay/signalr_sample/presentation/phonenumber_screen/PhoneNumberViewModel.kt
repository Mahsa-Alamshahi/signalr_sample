package com.gatepay.signalr_sample.presentation.phonenumber_screen

import androidx.lifecycle.ViewModel
import com.gatepay.signalr_sample.common.Resource
import com.gatepay.signalr_sample.data.data_source.remote.dto.LoginAndRegisterRequest
import com.gatepay.signalr_sample.data.data_source.remote.dto.LoginAndRegisterResponse
import com.gatepay.signalr_sample.domain.usecase.LoginAndRegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhoneNumberViewModel @Inject constructor(private val loginAndRegisterUseCase: LoginAndRegisterUseCase) :
    ViewModel() {

    suspend fun loginAndRegister(request: LoginAndRegisterRequest): Resource<LoginAndRegisterResponse> =
            loginAndRegisterUseCase(request)


}
