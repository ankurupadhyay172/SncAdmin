package com.ankurupadhyay.sncadmin.permission


import androidx.fragment.app.Fragment

inline fun Fragment.requestPermissions(
    vararg permissions:String,
    requestBlock:PermissionRequest.()->Unit
){
    PermissionManager.requestPermissions(this,*permissions){ this.requestCode }
}