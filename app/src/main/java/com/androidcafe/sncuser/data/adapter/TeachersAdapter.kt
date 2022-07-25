package com.androidcafe.sncuser.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.androidcafe.sncuser.R
import com.androidcafe.sncuser.base.BaseListAdapter
import com.androidcafe.sncuser.data.response.TeachersResponseModel
import com.androidcafe.sncuser.databinding.ItemTeachersBinding
import javax.inject.Inject

class TeachersAdapter @Inject constructor():
    BaseListAdapter<TeachersResponseModel.Result, ItemTeachersBinding>(DiffCallback()){

    var update:((id:String?)->Unit)? = null
    var delete:((id:String?)->Unit)? = null
    var open:((id:String?)->Unit)? = null

    class DiffCallback:DiffUtil.ItemCallback<TeachersResponseModel.Result>(){
        override fun areItemsTheSame(
            oldItem: TeachersResponseModel.Result,
            newItem: TeachersResponseModel.Result
        ): Boolean {
            return oldItem.student_id == newItem.student_id
        }

        override fun areContentsTheSame(
            oldItem: TeachersResponseModel.Result,
            newItem: TeachersResponseModel.Result
        ): Boolean {
            return oldItem==newItem
        }
    }

    override fun createBinding(parent: ViewGroup): ItemTeachersBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_teachers,parent,false)
    }

    override fun bind(binding: ItemTeachersBinding, item: TeachersResponseModel.Result?) {
        binding.model = item


    }

}
