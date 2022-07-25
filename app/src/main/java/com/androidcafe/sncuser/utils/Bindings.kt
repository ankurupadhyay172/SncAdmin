package com.androidcafe.sncuser.utils

import android.view.View
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter


@BindingAdapter("isLoading")
    fun ProgressBar.getLoading( show: Boolean){
        isVisible = show
    }


    @BindingAdapter("isVisible")
    fun View.showHide(show:Boolean){
        isVisible =show
    }
