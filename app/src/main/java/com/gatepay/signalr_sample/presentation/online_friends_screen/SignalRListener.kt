package com.gatepay.signalr_sample.presentation.online_friends_screen

import com.gatepay.signalr_sample.domain.model.Friend
import com.microsoft.signalr.Action1
import com.microsoft.signalr.HubConnection
import com.microsoft.signalr.HubConnectionBuilder
import com.microsoft.signalr.HubConnectionState
import io.reactivex.rxjava3.core.Single
import javax.inject.Singleton


@Singleton
class SignalRListener {

    lateinit var hubConnection: HubConnection
//    private var logger: Logger

   fun initConnection(chatToken: String) {
//        logger  = LoggerFactory.getLogger(HubConnection::class.java)
        // define in constructor
        hubConnection = HubConnectionBuilder.create("http://213.176.29.90:20911/ChatHub/OnConnect")
            .withAccessTokenProvider(Single.defer { Single.just("Bearer ${chatToken}") })
            .build()





//        hubConnection.on("JoinToHub",
//            Action1 { member: Member -> println(member.DisplayName + "online") },
//            Member::class.java
//        )
//
//        hubConnection.on("UserIsOffline",
//            Action1 { username: String -> println(username+" offline") },
//            String::class.java
//        )

        hubConnection.on(
            "ShowAllOnlineMyFriends",
            Action1 { friends : List<Friend> ->
                for (item in friends) {
                    println(item.UserNameFamily)
                }
            },
            List::class.java
        )
//        hubConnection.start().doOnError({ logger.info("Client connected error.") })
    }



//    private object Holder { val INSTANCE = SignalRListener() }

//    companion object {
//        @JvmStatic
//        fun getInstance(): SignalRListener{
//            return Holder.INSTANCE
//        }
//    }

//    fun stopHubConnection(){
//        if(hubConnection.connectionState == HubConnectionState.CONNECTED){
//            hubConnection.stop()
//        }
//    }

//    fun getConnectionState(){
//        println(hubConnection.connectionState.toString())
//    }

//    fun log(){
//        logger.info("Debug infor siganlR {}", hubConnection.connectionId)
//    }


    fun startConnection(): Boolean {
        if (hubConnection.connectionState == HubConnectionState.DISCONNECTED) {
        hubConnection.start()
          return true
        } else {
            return false
        }
    }

    fun stopConnection(): Boolean {
        if (hubConnection.connectionState == HubConnectionState.CONNECTED) {
        hubConnection.stop()
          return true
        } else {
            return false
        }
    }


    fun sendToServer(){
        if (hubConnection.connectionState == HubConnectionState.CONNECTED) {

        }

    }
}