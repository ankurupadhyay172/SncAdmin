package com.androidcafe.sncuser.data.request

data class SendNotificationRequestModel(val title:String?, val body:String?,val document:String?=null,
                                        val sendFrom:String?,val sendTo:String?,val selectedBranch:String?,val type:String?) {
}