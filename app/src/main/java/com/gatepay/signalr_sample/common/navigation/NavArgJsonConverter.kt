package com.gatepay.signalr_sample.common.navigation

import com.google.gson.Gson

object NavArgJsonConverter {


    fun <A> String.fromJson(type: Class<A>): A {
        return Gson().fromJson(this, type)
    }


    fun <A> A.toJson(): String? {
        return Gson().toJson(this)
    }
}