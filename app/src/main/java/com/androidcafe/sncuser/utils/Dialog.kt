package com.androidcafe.sncuser.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.androidcafe.sncuser.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

inline fun Activity.alert(
    titleResources:CharSequence?=null,
    message:CharSequence?=null,
    isCancelable:Boolean=true,
    func:AlertDialogHelper.()->Unit
):AlertDialog{
    return AlertDialogHelper(this,title,message,isCancelable).apply {
        func()
    }.create()
}

inline fun Fragment.alert(
    title: CharSequence?=null,
    message: CharSequence?=null,
    isCancelable: Boolean = true,
    func:AlertDialogHelper.()->Unit
):AlertDialog{
    return AlertDialogHelper(requireContext(),title,message,isCancelable).apply {
        func()
    }.create()
}


@SuppressLint("InflateParams")
class AlertDialogHelper(
    context: Context,
    title:CharSequence?,
    message: CharSequence?,
    cancelable:Boolean
){
    private val dialogView:View by lazy {
        LayoutInflater.from(context).inflate(R.layout.dialog_info,null)
    }


    private val builder:MaterialAlertDialogBuilder = MaterialAlertDialogBuilder(context).setView(dialogView)

    private val title:TextView by lazy {
        dialogView.findViewById(R.id.title)
    }

    private val message:TextView by lazy {
        dialogView.findViewById<TextView>(R.id.message).isVisible = true
        dialogView.findViewById(R.id.btnPositive)
    }

    private val positiveButton:Button by lazy {
        dialogView.findViewById<TextView>(R.id.btnPositive).isVisible = true
        dialogView.findViewById<Button>(R.id.btnPositive)
    }

    private val negativeButton:Button by lazy {
        dialogView.findViewById<TextView>(R.id.btnPositive).isVisible = true
        dialogView.findViewById(R.id.btnNegative)
    }

    private var dialog:AlertDialog? = null
    private var cancelable:Boolean = true

    init {
        this.title.text = title
        this.message.text = message
        this.cancelable = cancelable
    }

    fun positiveButton(@StringRes textResource:Int,func:(()->Unit)?=null){
        with(positiveButton){
            text = builder.context.getString(textResource)
            setClickListenerToDialogButton(func)
        }
    }


    fun positiveButton(text:CharSequence,func: (() -> Unit)?=null){
        with(positiveButton){
            this.text = text
            setClickListenerToDialogButton(func)
        }
    }

    fun negativeButton(text: CharSequence,func: (() -> Unit)?=null){
        with(negativeButton){
            this.text = text
            setClickListenerToDialogButton(func)
        }
    }

    fun onCancel(func: (() -> Unit)){
        builder.setOnCancelListener { func() }
    }

    fun create():AlertDialog{
        title.goneIfTextEmpty()
        message.goneIfTextEmpty()
        positiveButton.goneIfTextEmpty()
        negativeButton.goneIfTextEmpty()

        dialog = builder.setCancelable(cancelable).create()

        dialog!!.setCanceledOnTouchOutside(cancelable)
        return dialog!!
    }

    private fun TextView.goneIfTextEmpty(){
        visibility = if (text.isNullOrEmpty()){
            View.GONE
        }else{
            View.VISIBLE
        }
    }

    private fun Button.setClickListenerToDialogButton(func: (() -> Unit)?){
        setOnClickListener {
            func?.invoke()
            dialog?.dismiss()
        }
    }

    fun showLoadingDialog(context: Context?):ProgressDialog?{
        val progressDialog = ProgressDialog(context)
        progressDialog.show()

        if (progressDialog.window!=null){
            progressDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
        progressDialog.setContentView(R.layout.myprogress_layout)
        progressDialog.isIndeterminate = true
        progressDialog.setCancelable(false)
        progressDialog.setCanceledOnTouchOutside(false)
        return progressDialog
    }
}
