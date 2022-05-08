package com.ankurupadhyay.sncadmin.ui.beforestart

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ankurupadhyay.sncadmin.BR
import com.ankurupadhyay.sncadmin.R
import com.ankurupadhyay.sncadmin.base.BaseFragment
import com.ankurupadhyay.sncadmin.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreenFragment :BaseFragment<FragmentSplashBinding,AuthViewModel>(){
    val authViewModel: AuthViewModel by viewModels()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.myLooper()!!).postDelayed({
            navigationToMain()

        },2000)

    }

    private fun navigationToMain() {

                if (authViewModel.sessionManager.getUser()==null)
                findNavController().navigate(SplashScreenFragmentDirections.actionSplashScreenFragmentToCollegeSelectFragment())
                else
                    findNavController().navigate(SplashScreenFragmentDirections.actionSplashScreenFragmentToAdminHomeFragment())
    }


    override fun getLayoutId() = R.layout.fragment_splash
    override fun getBindingVariable() = BR.viewModel
    override fun getViewModel() = authViewModel
}