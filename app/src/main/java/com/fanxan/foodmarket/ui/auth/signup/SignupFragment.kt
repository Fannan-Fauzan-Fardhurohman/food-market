package com.fanxan.foodmarket.ui.auth.signup

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.fanxan.foodmarket.R
import com.fanxan.foodmarket.model.request.RegisterRequest
import com.fanxan.foodmarket.ui.auth.AuthActivity
import com.github.dhaval2404.imagepicker.ImagePicker
import kotlinx.android.synthetic.main.fragment_signin.*
import kotlinx.android.synthetic.main.fragment_signup.*
import kotlinx.android.synthetic.main.fragment_signup.et_email

class SignupFragment : Fragment() {
    var filePath: Uri? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initDummy()
        initListener()
    }

    private fun initListener() {
        ivProfile.setOnClickListener {
            ImagePicker.with(this)
                .cameraOnly()
                .start()
        }

        btnContinue.setOnClickListener {

            var fullName = et_fullname.text.toString()
            var email = et_email.text.toString()
            var password = et_passwordSignup.text.toString()

            if (fullName.isNullOrEmpty()) {
                et_fullname.error = "Silahkan Masukkan Nama Lengkap"
                et_fullname.requestFocus()
            } else if (email.isNullOrEmpty()) {
                et_email.error = "Silahkan Masukkan Email"
                et_email.requestFocus()
            } else if (password.isNullOrEmpty()) {
                et_passwordSignup.error = "Silahkan Masukkan Password"
                et_passwordSignup.requestFocus()
            } else {
                var data = RegisterRequest(
                    fullName,
                    email,
                    password,
                    password,
                    "",
                    "",
                    "",
                    "",
                    filePath
                )

                var bundle = Bundle()
                bundle.putParcelable("data", data)
                Navigation.findNavController(it)
                    .navigate(R.id.action_signup_address, bundle)
                (activity as AuthActivity).toolbarSignUpAddress()

            }

        }
    }

    private fun initDummy() {
        et_fullname.setText("Fannan Fauzan")
        et_email.setText("fannan123@gmail.com")
        et_passwordSignup.setText("12345678")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            filePath = data?.data

            Glide.with(this)
                .load(filePath)
                .apply(RequestOptions.circleCropTransform())
                .into(ivProfile)
        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(context, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Task Canceled", Toast.LENGTH_SHORT).show()
        }
    }
}