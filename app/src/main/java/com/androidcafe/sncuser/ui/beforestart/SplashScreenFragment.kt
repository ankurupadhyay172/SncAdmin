package com.androidcafe.sncuser.ui.beforestart

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.androidcafe.sncuser.BR
import com.androidcafe.sncuser.R
import com.androidcafe.sncuser.base.BaseFragment
import com.androidcafe.sncuser.databinding.FragmentSplashBinding

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreenFragment :Fragment(){
    val authViewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentSplashBinding.inflate(inflater,container,false)
        binding.lifecycleOwner = this
        return binding.root
    }


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


//    override fun getLayoutId() = R.layout.fragment_splash
//    override fun getBindingVariable() = BR.viewModel
//    override fun getViewModel() = authViewModel
}