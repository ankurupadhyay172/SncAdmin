package com.androidcafe.sncuser.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.androidcafe.sncuser.R
import com.androidcafe.sncuser.base.BaseListAdapter
import com.androidcafe.sncuser.data.response.SubjectsResponseModel
import com.androidcafe.sncuser.databinding.ItemSubjectsBinding
import javax.inject.Inject

class SubjectsAdapter @Inject constructor():
    BaseListAdapter<SubjectsResponseModel.Result, ItemSubjectsBinding>(DiffCallback()){

    var update:((id:String?)->Unit)? = null
    var delete:((id:String?)->Unit)? = null
    var open:((id:String?)->Unit)? = null

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
        binding.cardTitle.setOnClickListener {

            open?.invoke(item?.sub_id)
        }
    }

}
