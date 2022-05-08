package com.ankurupadhyay.sncadmin.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.ankurupadhyay.sncadmin.R
import com.ankurupadhyay.sncadmin.base.BaseListAdapter
import com.ankurupadhyay.sncadmin.data.response.CoursesResponseModel
import com.ankurupadhyay.sncadmin.data.response.SubjectsResponseModel
import com.ankurupadhyay.sncadmin.data.response.UserNotificationResponseModel
import com.ankurupadhyay.sncadmin.databinding.ItemCoursesBinding
import com.ankurupadhyay.sncadmin.databinding.ItemNotificationsBinding
import com.ankurupadhyay.sncadmin.databinding.ItemSubjectsBinding
import javax.inject.Inject

class SubjectsAdapter @Inject constructor():
    BaseListAdapter<SubjectsResponseModel.Result, ItemSubjectsBinding>(DiffCallback()){

    var update:((id:String?)->Unit)? = null
    var delete:((id:String?)->Unit)? = null
    var updateStatus:((id:String?,userid:String?)->Unit)? = null

    class DiffCallback:DiffUtil.ItemCallback<SubjectsResponseModel.Result>(){
        override fun areItemsTheSame(
            oldItem: SubjectsResponseModel.Result,
            newItem: SubjectsResponseModel.Result
        ): Boolean {
            return oldItem.course_id == newItem.course_id
        }

        override fun areContentsTheSame(
            oldItem: SubjectsResponseModel.Result,
            newItem: SubjectsResponseModel.Result
        ): Boolean {
            return oldItem==newItem
        }
    }

    override fun createBinding(parent: ViewGroup): ItemSubjectsBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_subjects,parent,false)
    }

    override fun bind(binding: ItemSubjectsBinding, item: SubjectsResponseModel.Result?) {
        binding.model = item
        //binding.tvTitle.setText(item?.sub_name)

    }

}
