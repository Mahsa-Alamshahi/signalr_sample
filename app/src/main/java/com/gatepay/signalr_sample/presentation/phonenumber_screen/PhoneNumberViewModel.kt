package com.gatepay.signalr_sample.presentation.phonenumber_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gatepay.signalr_sample.common.Resource
import com.gatepay.signalr_sample.data.data_source.remote.dto.LoginAndRegisterRequest
import com.gatepay.signalr_sample.data.data_source.remote.dto.LoginAndRegisterResponse
import com.gatepay.signalr_sample.domain.usecase.LoginAndRegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PhoneNumberViewModel @Inject constructor(private val loginAndRegisterUseCase: LoginAndRegisterUseCase) :
    ViewModel() {




    var isLoading = mutableStateOf(false)
    private var _getResponse: MutableLiveData<LoginAndRegisterResponse> = MutableLiveData()
    var getResponse: LiveData<LoginAndRegisterResponse> = _getResponse

    suspend fun loginAndRegister(request: LoginAndRegisterRequest): LoginAndRegisterResponse {
        return loginAndRegisterUseCase(request)
    }

//    private val _responseState = mutableStateOf(ResponseState())
//    val responseState: State<ResponseState> = _responseState

//    val state = mutableStateOf<Resource<LoginAndRegisterResponse>>(Resource.Loading())
//
//    fun loginAndRegister(request: LoginAndRegisterRequest) {
//        viewModelScope.launch {
//            var response = loginAndRegisterUseCase(request).collect { response ->
////                state.value = response
//                when (response) {
//                is Resource.Success -> {
//                    state.value = Resource.Success(data = response.data!!)
//                }
//
//                is Resource.Loading -> {
//                    state.value = Resource.Loading()
//                }
//
//                is Resource.Error -> {
//                    state.value =
//                        Resource.Error(message = response.message ?: "An error accured.")
//                }
//            }
//            }
//        }
//    }

//    fun loginAndRegister(request: LoginAndRegisterRequest) {
//        viewModelScope.launch {
//           var response = loginAndRegisterUseCase(request)
//            when (response) {
//                is Resource.Success -> {
//                    _responseState.value = ResponseState(loginResponse = response.data)
//                }
//
//                is Resource.Loading -> {
//                    _responseState.value = ResponseState(isLoading = true)
//                }
//
//                is Resource.Error -> {
//                    _responseState.value =
//                        ResponseState(error = response.message ?: "An error accured.")
//                }
//            }
//        }
//    }


}