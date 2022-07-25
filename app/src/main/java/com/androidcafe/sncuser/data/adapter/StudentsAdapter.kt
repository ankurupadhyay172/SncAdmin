package com.androidcafe.sncuser.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.androidcafe.sncuser.R
import com.androidcafe.sncuser.base.BaseListAdapter
import com.androidcafe.sncuser.data.response.StudentsResponseModel
import com.androidcafe.sncuser.databinding.ItemStudentsBinding
import javax.inject.Inject

class StudentsAdapter @Inject constructor():
    BaseListAdapter<StudentsResponseModel.Result, ItemStudentsBinding>(DiffCallback()){

    var update:((id:String?)->Unit)? = null
    var delete:((id:String?)->Unit)? = null
    var open:((id:String?)->Unit)? = null

    class DiffCallback:DiffUtil.ItemCallback<StudentsResponseModel.Result>(){
        override fun areItemsTheSame(
            oldItem: StudentsResponseModel.Result,
            newItem: StudentsResponseModel.Result
        ): Boolean {
            return oldItem.student_id == newItem.student_id
        }

        override fun areContentsTheSame(
            oldItem: StudentsResponseModel.Result,
            newItem: StudentsResponseModel.Result
        ): Boolean {
            return oldItem==newItem
        }
    }

    override fun createBinding(parent: ViewGroup): ItemStudentsBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_students,parent,false)
    }

    override fun bind(binding: ItemStudentsBinding, item: StudentsResponseModel.Result?) {
        binding.model = item


    }

}
