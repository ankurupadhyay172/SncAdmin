package com.ankurupadhyay.sncadmin.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ankurupadhyay.sncadmin.BR
import com.ankurupadhyay.sncadmin.R
import com.ankurupadhyay.sncadmin.base.BaseFragment
import com.ankurupadhyay.sncadmin.databinding.FragmentAdminHomeBinding
import com.ankurupadhyay.sncadmin.databinding.FragmentLoginUserBinding
import com.ankurupadhyay.sncadmin.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdminHomeFragment :BaseFragment<FragmentAdminHomeBinding,HomeViewModel>(){
    val authViewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getViewDataBinding().sentNews.setOnClickListener {
            findNavController().navigate(AdminHomeFragmentDirections.actionAdminHomeFragmentToNotificationsFragment())
        }

        getViewDataBinding().subjectLayout.setOnClickListener {
            findNavController().navigate(AdminHomeFragmentDirections.actionAdminHomeFragmentToCoursesFragment())
        }
    }



    override fun getLayoutId() = R.layout.fragment_admin_home
    override fun getBindingVariable() = BR.viewModel
    override fun getViewModel() = authViewModel
}