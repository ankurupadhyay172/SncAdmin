package com.ankurupadhyay.sncadmin.ui.home.notifications

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ankurupadhyay.sncadmin.BR
import com.ankurupadhyay.sncadmin.R
import com.ankurupadhyay.sncadmin.base.BaseFragment
import com.ankurupadhyay.sncadmin.data.request.SendNotificationRequestModel
import com.ankurupadhyay.sncadmin.databinding.*
import com.ankurupadhyay.sncadmin.session.SessionManager
import com.ankurupadhyay.sncadmin.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_add_notification.*
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.util.*
import javax.inject.Inject

const val PDF_REQ=101
@AndroidEntryPoint
class AddNotificationFragment :BaseFragment<FragmentAddNotificationBinding, HomeViewModel>(){
    val homeViewModel: HomeViewModel by viewModels()
    @Inject
    lateinit var sessionManager: SessionManager

    val args:AddNotificationFragmentArgs by navArgs()
    var encodeString:String? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getViewDataBinding().ivType.setImageResource(args.image)
        getViewDataBinding().tvItems.text = args.title

        getViewDataBinding().liItem.setOnClickListener {
            findNavController().popBackStack()
        }

        getViewDataBinding().addPhoto.setOnClickListener {
            checkForPermission(Manifest.permission.READ_EXTERNAL_STORAGE,"storage", PDF_REQ)
        }

        getViewDataBinding().save.setOnClickListener {
            showLoading(true)
            homeViewModel.createNotification(SendNotificationRequestModel(edtTitle.text.toString(),edtDetails.text.toString(),encodeString,sessionManager.getUser()?.id,
                args.title.toString().lowercase(Locale.getDefault()),sessionManager.getUser()?.staff_branch,"add")).observe(viewLifecycleOwner){
                showLoading(false)
                if(it.status==1)
                    {
                         showToast(it.result)
                         findNavController().popBackStack()
                    }
                if (it.status==0){
                    showToast(it.result)
                }
            }
        }

    }



    private fun checkForPermission(permissions: String, name: String, requestCode: Int) {
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.M)
        {
            when{
                ContextCompat.checkSelfPermission(requireContext(),permissions)== PackageManager.PERMISSION_GRANTED->{
                    //  showToast("$name permission granted")
                    pickImageFromGallery()
                }
                shouldShowRequestPermissionRationale(permissions)->showDialog(permissions,name,requestCode)
                else-> ActivityCompat.requestPermissions(requireActivity(), arrayOf(permissions),requestCode)
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        var filePath = data?.data
        if (requestCode== PDF_REQ&&resultCode== Activity.RESULT_OK)
        {
            getViewDataBinding().ivShowImage.setImageResource(R.drawable.ic_pdf)
            getViewDataBinding().addPhoto.text = "Update Document"
            val inputStream = context?.contentResolver?.openInputStream(filePath!!)
            val bytes = getBytes(inputStream)
            encodeString = Base64.encodeToString(bytes,Base64.DEFAULT)
            Log.d("mylogresponse","$encodeString")


        }
    }

    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.type = "application/pdf"
        startActivityForResult(intent, PDF_REQ)
    }



    private fun showDialog(permissions: String, name: String, requestCode: Int) {

        val builder = AlertDialog.Builder(requireContext())

        builder.apply {
            setMessage("Permission to access your $name is required to use this app")
                .setTitle("Permission Required")
                .setPositiveButton("OK"){ _, _ ->
                    ActivityCompat.requestPermissions(requireActivity(), arrayOf(permissions),requestCode)
                }
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    @Throws(IOException::class)
    fun getBytes(inputStream: InputStream?): ByteArray? {
        val byteBuffer = ByteArrayOutputStream()
        val bufferSize = 1024
        val buffer = ByteArray(bufferSize)
        var len = 0
        while (inputStream!!.read(buffer).also { len = it } != -1) {
            byteBuffer.write(buffer, 0, len)
        }
        return byteBuffer.toByteArray()
    }


    override fun getLayoutId() = R.layout.fragment_add_notification
    override fun getBindingVariable() = BR.viewModel
    override fun getViewModel() = homeViewModel
}