package com.gatepay.signalr_sample.presentation.phonenumber_screen

import com.gatepay.signalr_sample.data.data_source.remote.dto.LoginAndRegisterResponse

data class ResponseState( val isLoading: Boolean = false,
                          val loginResponse: LoginAndRegisterResponse? = null,
                          val error: String = "")
