package com.ankurupadhyay.sncadmin.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.ankurupadhyay.sncadmin.R
import com.ankurupadhyay.sncadmin.base.BaseListAdapter
import com.ankurupadhyay.sncadmin.data.response.CoursesResponseModel
import com.ankurupadhyay.sncadmin.data.response.UserNotificationResponseModel
import com.ankurupadhyay.sncadmin.databinding.ItemCoursesBinding
import com.ankurupadhyay.sncadmin.databinding.ItemNotificationsBinding
import javax.inject.Inject

class CoursesAdapter @Inject constructor():
    BaseListAdapter<CoursesResponseModel.Result, ItemCoursesBinding>(DiffCallback()){

    var update:((id:String?)->Unit)? = null
    var delete:((id:String?)->Unit)? = null
    var open:((id:String?)->Unit)? = null

    class DiffCallback:DiffUtil.ItemCallback<CoursesResponseModel.Result>(){
        override fun areItemsTheSame(
            oldItem: CoursesResponseModel.Result,
            newItem: CoursesResponseModel.Result
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: CoursesResponseModel.Result,
            newItem: CoursesResponseModel.Result
        ): Boolean {
            return oldItem==newItem
        }
    }

    override fun createBinding(parent: ViewGroup): ItemCoursesBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_courses,parent,false)
    }

    override fun bind(binding: ItemCoursesBinding, item: CoursesResponseModel.Result?) {
        binding.model = item

        binding.cardTitle.setOnClickListener {

            open?.invoke(item?.id)
        }
    }

}
