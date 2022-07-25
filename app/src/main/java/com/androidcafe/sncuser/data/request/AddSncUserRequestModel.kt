package com.androidcafe.sncuser.data.request

data class AddSncUserRequestModel(val userid:String?, val pass:String?, val course:String?,
                                  val subjects:String?=null, val name:String?, val branch:String?, val year:String?=null)