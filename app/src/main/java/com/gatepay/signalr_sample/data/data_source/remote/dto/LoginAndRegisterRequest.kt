package com.gatepay.signalr_sample.data.data_source.remote.dto

data class LoginAndRegisterRequest(
    val checkPrivateNumber: Boolean,
    val domainName: String,
    val parentId: String,
    val password: String,
    val userName: String
)