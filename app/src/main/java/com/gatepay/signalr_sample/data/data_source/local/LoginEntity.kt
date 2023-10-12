package com.gatepay.signalr_sample.data.data_source.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "login")
data class LoginEntity(
    @ColumnInfo(name = "first_name") var firstName: String? = null,
    @ColumnInfo(name = "last_name") var lastName: String? = null,
    @ColumnInfo(name = "user_id") var userId: Int? = null,
    @ColumnInfo(name = "username") var username: String? = null,
    @ColumnInfo(name = "chat_token") var chatToken: String? = null,
    @ColumnInfo(name = "automation_token") var automationToken: String? = null,
    @ColumnInfo(name = "advertisement_token") var advertisementToken: String? = null,
    @ColumnInfo(name = "console_token") var consoleToken: String? = null,
    @ColumnInfo(name = "expire_date") var expireDate: String? = null,
    @ColumnInfo(name = "institution_token") var institutionToken: String? = null,
    @ColumnInfo(name = "library_token") var libraryToken: String? = null,
    @ColumnInfo(name = "monitoring_token") var monitoringToken: String? = null,
    @ColumnInfo(name = "notice_token") var noticeToken: String? = null,
    @ColumnInfo(name = "paying_wages_token") var payingWagesToken: String? = null,
    @ColumnInfo(name = "public_token") var publicToken: String? = null,
    @ColumnInfo(name = "push_notifications_token") var pushNotificationsToken: String? = null,
    @ColumnInfo(name = "sms_log_token") var smsLogToken: String? = null,
    @ColumnInfo(name = "store_token") var storeToken: String? = null,
    @ColumnInfo(name = "password") var password: String? = null,




    ) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}

