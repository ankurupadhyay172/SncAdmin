package com.androidcafe.sncuser.utils

import androidx.annotation.IdRes
import com.androidcafe.sncuser.R

enum class PageConfiguration (
    val id:Int,
    val toolbarVisible:Boolean = true,
    val bottomNavigationBarVisible:Boolean = false,
    val isTopLeval:Boolean = false)
{
    SPLASH(
      R.id.splashScreenFragment,
        toolbarVisible = false
    ), HOME(
    R.id.adminHomeFragment,
    toolbarVisible = true
    ),
    OTHER(0);

    companion object{
        fun getConfiguration(@IdRes id:Int):PageConfiguration{
            return values().firstOrNull{it.id==id}?:OTHER
        }
    }






}