package com.gatepay.signalr_sample.data.data_source.remote.dto

import com.google.gson.annotations.SerializedName

data class MultiLoginResponse(
    @SerializedName("ContentType")
    val contentType: String,
    @SerializedName("Message")
    val message: String,
    @SerializedName("Record")
    val recordResponse: RecordResponse,
    @SerializedName("Result")
    val result: String,
    @SerializedName("SerializerSettings")
    val serializerSettings: String,
    @SerializedName("StatusCode")
    val statusCode: String,
    @SerializedName("Value")
    val value: ValueX
)