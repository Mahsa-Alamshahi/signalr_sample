package com.gatepay.signalr_sample.data.data_source.remote.dto

import com.gatepay.signalr_sample.data.data_source.local.LoginEntity
import com.google.gson.annotations.SerializedName

data class RecordResponse(
    @SerializedName("AdvertisementToken")
    val advertisementToken: String,
    @SerializedName("AutomationToken")
    val automationToken: String,
    @SerializedName("ChatToken")
    val chatToken: String,
    @SerializedName("ConsoleToken")
    val consoleToken: String,
    @SerializedName("DateTimeNow")
    val dateTimeNow: String,
    @SerializedName("ExpireDate")
    val expireDate: String,
    @SerializedName("FirstName")
    val firstName: String,
    @SerializedName("InstitutionToken")
    val institutionToken: String,
    @SerializedName("LastName")
    val lastName: String,
    @SerializedName("LibraryToken")
    val libraryToken: String,
    @SerializedName("MonitoringToken")
    val monitoringToken: String,
    @SerializedName("NoticeToken")
    val noticeToken: String,
    @SerializedName("PayingWagesToken")
    val payingWagesToken: String,
    @SerializedName("PublicToken")
    val publicToken: String,
    @SerializedName("PushNotificationsToken")
    val pushNotificationsToken: String,
    @SerializedName("SmsLogToken")
    val smsLogToken: String,
    @SerializedName("StoreToken")
    val storeToken: String,
    @SerializedName("UserId")
    val userId: Int,
    @SerializedName("Username")
    val username: String
)


fun RecordResponse.toLoginEntity(password: String): LoginEntity {
    return LoginEntity(
        firstName = firstName,
        lastName = lastName,
        username = username,
        userId = userId,
        chatToken = chatToken,
        publicToken = publicToken,
        automationToken = automationToken,
        payingWagesToken = payingWagesToken,
        advertisementToken = advertisementToken,
        consoleToken = consoleToken,
        pushNotificationsToken = pushNotificationsToken,
        institutionToken = institutionToken,
        libraryToken = libraryToken,
        expireDate = expireDate,
        monitoringToken = monitoringToken,
        noticeToken = noticeToken,
        smsLogToken = smsLogToken,
        storeToken = storeToken,
        password = password
    )

}