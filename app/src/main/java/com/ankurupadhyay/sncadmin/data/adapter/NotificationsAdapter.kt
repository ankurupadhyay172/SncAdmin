package com.ankurupadhyay.sncadmin.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.ankurupadhyay.sncadmin.R
import com.ankurupadhyay.sncadmin.base.BaseListAdapter
import com.ankurupadhyay.sncadmin.data.response.UserNotificationResponseModel
import com.ankurupadhyay.sncadmin.databinding.ItemNotificationsBinding
import javax.inject.Inject

class NotificationsAdapter @Inject constructor():
    BaseListAdapter<UserNotificationResponseModel.Result, ItemNotificationsBinding>(DiffCallback()){

    var update:((id:String?)->Unit)? = null
    var delete:((id:String?)->Unit)? = null
    var updateStatus:((id:String?,userid:String?)->Unit)? = null

    class DiffCallback:DiffUtil.ItemCallback<UserNotificationResponseModel.Result>(){
        override fun areItemsTheSame(
            oldItem: UserNotificationResponseModel.Result,
            newItem: UserNotificationResponseModel.Result
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: UserNotificationResponseModel.Result,
            newItem: UserNotificationResponseModel.Result
        ): Boolean {
            return oldItem==newItem
        }
    }

    override fun createBinding(parent: ViewGroup): ItemNotificationsBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_notifications,parent,false)
    }

    override fun bind(binding: ItemNotificationsBinding, item: UserNotificationResponseModel.Result?) {
        binding.model = item
    }

}
