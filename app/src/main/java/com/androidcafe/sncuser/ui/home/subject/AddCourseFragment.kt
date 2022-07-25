package com.androidcafe.sncuser.ui.home.subject

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.androidcafe.sncuser.BR
import com.androidcafe.sncuser.R
import com.androidcafe.sncuser.base.BaseFragment
import com.androidcafe.sncuser.data.request.CourseRequestModel
import com.androidcafe.sncuser.databinding.*
import com.androidcafe.sncuser.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddCourseFragment :BaseFragment<FragmentAddCourseBinding, HomeViewModel>(){
    val homeViewModel: HomeViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getViewDataBinding().lifecycleOwner = this




        getViewDataBinding().submit.setOnClickListener {
            getCourseData()
            showLoading(true)
        }

    }

    private fun getCourseData() {

        homeViewModel.addCourse(CourseRequestModel(getViewDataBinding().edtName.text.toString(),homeViewModel.sessionManager.getUser()?.staff_branch)).observe(viewLifecycleOwner){
            showLoading(false)
            if (it.status==1)
            {
                showToast(it.result)
                findNavController().popBackStack()
            }
            if (it.status==0)
            {
                showToast(it.result)
            }
        }


    }


    override fun getLayoutId() = R.layout.fragment_add_course
    override fun getBindingVariable() = BR.viewModel
    override fun getViewModel() = homeViewModel
}