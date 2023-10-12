package com.gatepay.signalr_sample.domain.model

data class Friend(var UserId: Long,
                  var ConnectionId: String,
                  var GroupName: String,
                  var UserNameFamily: String,
                  var PhoneNumber: String,
                  var Status: String,
                  var StatusColor: String)
