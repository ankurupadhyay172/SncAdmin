package com.androidcafe.sncuser.ui.home.notifications

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.androidcafe.sncuser.BR
import com.androidcafe.sncuser.R
import com.androidcafe.sncuser.base.BaseFragment
import com.androidcafe.sncuser.databinding.*
import com.androidcafe.sncuser.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectSenderNotificationFragment :BaseFragment<FragmentSelectSenderBinding, HomeViewModel>(){
    val homeViewModel: HomeViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getViewDataBinding().onclick = View.OnClickListener {
            when(it.id)
            {
                R.id.ivStudent,R.id.tvStudent,R.id.liStudent->{findNavController().navigate(SelectSenderNotificationFragmentDirections.actionSelectSenderNotificationFragmentToAddNotificationFragment(R.drawable.student,"Student"))}
                R.id.liTeacher->{findNavController().navigate(SelectSenderNotificationFragmentDirections.actionSelectSenderNotificationFragmentToAddNotificationFragment(R.drawable.teacher,"Teacher"))}
                R.id.liAll->{findNavController().navigate(SelectSenderNotificationFragmentDirections.actionSelectSenderNotificationFragmentToAddNotificationFragment(R.drawable.document,"All"))}
            }
    }
        }





    override fun getLayoutId() = R.layout.fragment_select_sender
    override fun getBindingVariable() = BR.viewModel
    override fun getViewModel() = homeViewModel
}