package com.gatepay.signalr_sample.data.repository

import com.gatepay.signalr_sample.common.Resource
import com.gatepay.signalr_sample.data.data_source.remote.ApiService
import com.gatepay.signalr_sample.data.data_source.remote.dto.LoginAndRegisterRequest
import com.gatepay.signalr_sample.data.data_source.remote.dto.LoginAndRegisterResponse
import com.gatepay.signalr_sample.data.data_source.remote.dto.MultiLoginResponse
import com.gatepay.signalr_sample.domain.repository.LoginAndRegisterRepository
import com.orhanobut.logger.Logger
import retrofit2.HttpException
import javax.inject.Inject

class LoginAndRegisterRepositoryImpl @Inject constructor(private val apiService: ApiService) : LoginAndRegisterRepository {

    override suspend fun loginAndRegister(request: LoginAndRegisterRequest): Resource<LoginAndRegisterResponse>  {
        try {
            return Resource.Success(apiService.loginAndRegister(request))
        } catch (e: Exception){
            Logger.d(e.message)
            return Resource.Error(e.message!!)
        } catch (e: HttpException) {
            Logger.d(e.message)
            return Resource.Error(e.message!!)
        }

    }

    override suspend fun multiLogin(request: LoginAndRegisterRequest): Resource<MultiLoginResponse> {
        try {
            return Resource.Success(apiService.multiLogin(request))
        } catch (e: Exception){
            Logger.d(e.message)
            return Resource.Error(e.message!!)
        } catch (e: HttpException) {
            Logger.d(e.message)
            return Resource.Error(e.message!!)
        }

    }
}