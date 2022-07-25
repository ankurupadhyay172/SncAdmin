package com.androidcafe.sncuser.permission

class PermissionRequest {
    var requestCode:Int?=100
    var resultCallback:(PermissionResult.()->Unit)?=null
}