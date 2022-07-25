package com.androidcafe.sncuser.ui.beforestart

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.androidcafe.sncuser.BR
import com.androidcafe.sncuser.R
import com.androidcafe.sncuser.base.BaseFragment
import com.androidcafe.sncuser.databinding.FragmentSelectCollegeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CollegeSelectFragment :BaseFragment<FragmentSelectCollegeBinding,AuthViewModel>(){
    val authViewModel: AuthViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getViewDataBinding().sncDungarpur.setOnClickListener {
            findNavController().navigate(CollegeSelectFragmentDirections.actionCollegeSelectFragmentToLoginUserFragment("dungarpur"))
        }
        getViewDataBinding().sncSimalWara.setOnClickListener {
            findNavController().navigate(CollegeSelectFragmentDirections.actionCollegeSelectFragmentToLoginUserFragment("simalwara"))
        }
    }


    override fun getLayoutId() = R.layout.fragment_select_college
    override fun getBindingVariable() = BR.viewModel
    override fun getViewModel() = authViewModel
}