package com.gatepay.signalr_sample.presentation

import androidx.lifecycle.ViewModel
import com.gatepay.signalr_sample.domain.usecase.CheckUserExistanceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val checkUserExistanceUseCase: CheckUserExistanceUseCase): ViewModel() {

    suspend fun isUserExisted(): Boolean =
        checkUserExistanceUseCase()

}