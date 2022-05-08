package com.ankurupadhyay.sncadmin.ui.home.subject

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ankurupadhyay.sncadmin.BR
import com.ankurupadhyay.sncadmin.R
import com.ankurupadhyay.sncadmin.base.BaseFragment
import com.ankurupadhyay.sncadmin.data.adapter.CoursesAdapter
import com.ankurupadhyay.sncadmin.data.adapter.NotificationsAdapter
import com.ankurupadhyay.sncadmin.data.adapter.SubjectsAdapter
import com.ankurupadhyay.sncadmin.data.request.CommonRequestModel
import com.ankurupadhyay.sncadmin.databinding.FragmentAdminHomeBinding
import com.ankurupadhyay.sncadmin.databinding.FragmentLoginUserBinding
import com.ankurupadhyay.sncadmin.databinding.FragmentNotificationsBinding
import com.ankurupadhyay.sncadmin.databinding.FragmentSplashBinding
import com.ankurupadhyay.sncadmin.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CourseSubjectFragment :BaseFragment<FragmentNotificationsBinding, HomeViewModel>(){
    val homeViewModel: HomeViewModel by viewModels()

    val args:CourseSubjectFragmentArgs by navArgs()
    @Inject
    lateinit var adapter:SubjectsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getViewDataBinding().lifecycleOwner = this
        getViewDataBinding().rvData.adapter = adapter

        getCourseData()
        showLoading(true)


        getViewDataBinding().fabAdd.setOnClickListener {
            findNavController().navigate(CourseSubjectFragmentDirections.actionCourseSubjectFragmentToAddSubjectFragment(args.id))
        }
    }

    private fun getCourseData() {

        homeViewModel.readSubjects(CommonRequestModel( args.id)).observe(viewLifecycleOwner){
            showLoading(false)
            adapter.submitList(it.result)
        }


    }


    override fun getLayoutId() = R.layout.fragment_notifications
    override fun getBindingVariable() = BR.viewModel
    override fun getViewModel() = homeViewModel
}