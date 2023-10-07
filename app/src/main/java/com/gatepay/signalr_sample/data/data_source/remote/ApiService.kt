package com.gatepay.signalr_sample.data.data_source.remote

import com.gatepay.signalr_sample.data.data_source.remote.dto.LoginAndRegisterRequest
import com.gatepay.signalr_sample.data.data_source.remote.dto.LoginAndRegisterResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @POST("LoginAndRegisterWithSendSms")
    suspend fun loginAndRegister(@Body request: LoginAndRegisterRequest): LoginAndRegisterResponse
  @POST("LoginAndRegisterWithSendSms")
    suspend fun multiLogin(@Body request: LoginAndRegisterRequest): LoginAndRegisterResponse

}