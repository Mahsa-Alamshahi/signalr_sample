package com.gatepay.signalr_sample.data.data_source.remote.dto

data class LoginAndRegisterRequest(
    var checkPrivateNumber: Boolean,
    var domainName: String,
    var parentId: String,
    var password: String,
    var userName: String
)