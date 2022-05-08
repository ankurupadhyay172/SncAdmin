package com.ankurupadhyay.sncadmin.ui.beforestart

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ankurupadhyay.sncadmin.BR
import com.ankurupadhyay.sncadmin.R
import com.ankurupadhyay.sncadmin.base.BaseFragment
import com.ankurupadhyay.sncadmin.data.request.UserLoginRequestModel
import com.ankurupadhyay.sncadmin.databinding.FragmentLoginUserBinding
import com.ankurupadhyay.sncadmin.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_login_user.*

@AndroidEntryPoint
class LoginUserFragment :BaseFragment<FragmentLoginUserBinding,AuthViewModel>(){
    val authViewModel: AuthViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getViewDataBinding().lifecycleOwner = this

        getViewDataBinding().button.setOnClickListener {
            //findNavController().navigate(LoginUserFragmentDirections.actionLoginUserFragmentToAdminHomeFragment())
            getViewDataBinding().button.visibility = View.GONE

            loginUser()
        }
    }

    private fun loginUser() {
        authViewModel.loginUser(UserLoginRequestModel(mobile.text.toString(),password.text.toString())).observe(viewLifecycleOwner){
            it.getValueOrNull()?.let {
                if (it.status==1)
                {
                    authViewModel.sessionManager.saveUser(it.result[0])
                    findNavController().navigate(LoginUserFragmentDirections.actionLoginUserFragmentToAdminHomeFragment())
                }
                if (it.status==0)
                {
                    getViewDataBinding().button.visibility = View.VISIBLE


                }
            }
        }
    }


    override fun getLayoutId() = R.layout.fragment_login_user
    override fun getBindingVariable() = BR.viewModel
    override fun getViewModel() = authViewModel
}