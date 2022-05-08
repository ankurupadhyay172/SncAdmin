package com.ankurupadhyay.sncadmin.ui.home.subject

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ankurupadhyay.sncadmin.BR
import com.ankurupadhyay.sncadmin.R
import com.ankurupadhyay.sncadmin.base.BaseFragment
import com.ankurupadhyay.sncadmin.data.adapter.CoursesAdapter
import com.ankurupadhyay.sncadmin.data.adapter.NotificationsAdapter
import com.ankurupadhyay.sncadmin.data.request.CommonRequestModel
import com.ankurupadhyay.sncadmin.databinding.FragmentAdminHomeBinding
import com.ankurupadhyay.sncadmin.databinding.FragmentLoginUserBinding
import com.ankurupadhyay.sncadmin.databinding.FragmentNotificationsBinding
import com.ankurupadhyay.sncadmin.databinding.FragmentSplashBinding
import com.ankurupadhyay.sncadmin.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class StudentsFragment :BaseFragment<FragmentNotificationsBinding, HomeViewModel>(){
    val homeViewModel: HomeViewModel by viewModels()

    @Inject
    lateinit var adapter:CoursesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getViewDataBinding().lifecycleOwner = this
        getViewDataBinding().rvData.adapter = adapter

        getCourseData()
        showLoading(true)
        getViewDataBinding().fabAdd.setOnClickListener {
            findNavController().navigate(CoursesFragmentDirections.actionCoursesFragmentToAddCourseFragment())
        }

    }

    private fun getCourseData() {

        homeViewModel.readCourses(CommonRequestModel( homeViewModel.sessionManager.getUser()?.staff_branch)).observe(viewLifecycleOwner){
            showLoading(false)
            adapter.submitList(it.result)
        }

        adapter.open = {
            findNavController().navigate(CoursesFragmentDirections.actionCoursesFragmentToCourseSubjectFragment(it))
        }

    }


    override fun getLayoutId() = R.layout.fragment_notifications
    override fun getBindingVariable() = BR.viewModel
    override fun getViewModel() = homeViewModel
}