package com.androidcafe.sncuser.ui.home.subject

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.androidcafe.sncuser.BR
import com.androidcafe.sncuser.base.BaseFragment
import com.androidcafe.sncuser.data.request.AddSncUserRequestModel
import com.androidcafe.sncuser.databinding.*
import com.androidcafe.sncuser.ui.home.HomeViewModel
import com.androidcafe.sncuser.databinding.FragmentAddTeacherBinding
import com.androidcafe.sncuser.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_add_course.edtName
import kotlinx.android.synthetic.main.fragment_add_teacher.*

@AndroidEntryPoint
class AddTeacherFragment :BaseFragment<FragmentAddTeacherBinding, HomeViewModel>(){
    val homeViewModel: HomeViewModel by viewModels()
    private val args:AddTeacherFragmentArgs by navArgs()

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
        args.course,edtSubjects.text.toString(),edtName.text.toString(),homeViewModel.sessionManager.getUser()?.staff_branch)).observe(viewLifecycleOwner){
            showLoading(false)
            it.getValueOrNull().let { it1 ->
                if (it1?.status==1){
                    showToast("${it1.result}")
                    findNavController().popBackStack()
                }
                if (it1?.status==0){
                    showToast("${it1.result}")
                }
            }
        }
    }


    override fun getLayoutId() = R.layout.fragment_add_teacher
    override fun getBindingVariable() = BR.viewModel
    override fun getViewModel() = homeViewModel
}