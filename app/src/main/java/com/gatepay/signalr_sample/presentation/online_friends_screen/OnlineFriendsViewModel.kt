package com.gatepay.signalr_sample.presentation.online_friends_screen


import androidx.lifecycle.ViewModel
import com.gatepay.signalr_sample.data.data_source.local.LoginEntity
import com.gatepay.signalr_sample.domain.usecase.GetUserLoginInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class OnlineFriendsViewModel @Inject constructor(
    private val getUserLoginInfoUseCase: GetUserLoginInfoUseCase
) : ViewModel() {



    suspend fun getUser(): List<LoginEntity> =
        getUserLoginInfoUseCase()




//        hubConnection.start().doOnError {
//            Logger.d("${it.stackTrace}")
//        }
//            .doOnComplete {
//                Logger.d("completed")
//            }




//        hubConnection.on(
//            "JoinToHub",
//            Action1 { friends: List<Friend> ->
//                for (item in friends) {
//                    println(item.UserNameFamily)
//                }
//            },
//            List::class.java
//        )
    }


//    fun startConnection(): Boolean {
//        Logger.d(hubConnection.connectionState)
//        if (hubConnection.connectionState == HubConnectionState.DISCONNECTED) {
//            hubConnection.start()
//            return true
//        } else {
//            return false
//        }
//
//    }
//
//    fun stopConnection(): Boolean {
//        if (hubConnection.connectionState == HubConnectionState.CONNECTED) {
//            hubConnection.stop()
//            return true
//        } else {
//            return false
//        }
//    }


//    fun sendToServer() {
//        if (hubConnection.connectionState == HubConnectionState.CONNECTED) {
//            hubConnection.send("")
//        }
//
//    }


//    private fun initConnection() {
//
//        hubConnection = HubConnectionBuilder.create("http://213.176.29.90:20911/ChatHub/OnConnect").build()
//
//
//        if (hubConnection.connectionState == HubConnectionState.DISCONNECTED) {
//            hubConnection.start()
//            hubConnection.send("ShowAllOnlineMyFriends")
//        }


//        hubConnection.on(
//            "ShowAllOnlineMyFriends",
//            Action1 { usersOnline: List<Friend> ->
//                for (item in usersOnline) {
//                    println(item.PhoneNumber)
//                }
//            },
//            List::class.java
//        )

//        try {
//            webSocketTransport =
//                WebSocketTransportExtension(URL, object : WebSocketClientListener {
//                    override fun onOpen() {
//                        System.out.println("Connected to $URL")
//                    }
//
//                    override fun onMessage(message: String?) {}
//                    override fun onClose(code: Int, reason: String?, remote: Boolean) {
//                        println("Connection Closed")
//                    }
//
//                    override fun onError(ex: Exception) {
//                        println("Error: " + ex.message)
//                    }
//                })
//            connection = HubConnection(URL, webSocketTransport)
//            connection!!.on(
//                "newMessage", { message -> println("REGISTERED HANDLER: $message") },
//                String::class.java
//            )
//        } catch (e: URISyntaxException) {
//            e.printStackTrace()
//        }
//    }


//    fun onConnect(v: View?) {
//        try {
//            connection!!.start()
//            connection!!.send("JoinGroup", "5b3635543abb33403ca433c1:5b3635543abb33403ca433c1")
//        } catch (e: java.lang.Exception) {
//            e.printStackTrace()
//        }
//    }
