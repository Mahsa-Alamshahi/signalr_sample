package com.gatepay.signalr_sample.presentation.password_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gatepay.signalr_sample.common.Resource
import com.gatepay.signalr_sample.data.data_source.remote.dto.LoginAndRegisterRequest
import com.gatepay.signalr_sample.data.data_source.remote.dto.MultiLoginResponse
import com.gatepay.signalr_sample.data.data_source.remote.dto.RecordResponse
import com.gatepay.signalr_sample.domain.usecase.AddUserIntoDBUseCase
import com.gatepay.signalr_sample.domain.usecase.MultiLoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PasswordViewModel @Inject constructor(
    private val multiLoginUseCase: MultiLoginUseCase,
    private val addUserIntoDBUseCase: AddUserIntoDBUseCase
): ViewModel() {


    suspend fun multiLogin(request: LoginAndRegisterRequest): Resource<MultiLoginResponse> =
        multiLoginUseCase(request)



    fun addUser(recordResponse: RecordResponse, password: String){
        viewModelScope.launch {
            addUserIntoDBUseCase(recordResponse, password)
        }
    }
}