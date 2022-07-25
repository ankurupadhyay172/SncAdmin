package com.androidcafe.sncuser.ui.home.subject

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.androidcafe.sncuser.BR
import com.androidcafe.sncuser.R
import com.androidcafe.sncuser.base.BaseFragment
import com.androidcafe.sncuser.data.request.AddSncUserRequestModel
import com.androidcafe.sncuser.databinding.*
import com.androidcafe.sncuser.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_add_course.edtName
import kotlinx.android.synthetic.main.fragment_add_student.*


@AndroidEntryPoint
class AddStudentFragment :BaseFragment<FragmentAddStudentBinding, HomeViewModel>(){
    val homeViewModel: HomeViewModel by viewModels()
    val args:AddStudentFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getViewDataBinding().lifecycleOwner = this

        getViewDataBinding().submit.setOnClickListener {
            addTeacher()
            showLoading(true)
        }

    }

    private fun addTeacher() {
        homeViewModel.addSncUser(AddSncUserRequestModel(edtUserId.text.toString(),edtPass.text.toString(),
        args.course,name = edtName.text.toString(),branch = homeViewModel.sessionManager.getUser()?.staff_branch,year = args.year)).observe(viewLifecycleOwner){
            showLoading(false)
            it.getValueOrNull().let {
                if (it?.status==1){
                    showToast("${it.result}")
                    findNavController().popBackStack()
                }
                if (it?.status==0){
                    showToast("${it.result}")
                }
            }
        }
    }


    override fun getLayoutId() = R.layout.fragment_add_student
    override fun getBindingVariable() = BR.viewModel
    override fun getViewModel() = homeViewModel
}