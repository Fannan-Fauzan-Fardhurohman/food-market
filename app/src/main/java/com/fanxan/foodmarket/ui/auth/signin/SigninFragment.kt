package com.fanxan.foodmarket.ui.auth.signin

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.fanxan.foodmarket.FoodMarket
import com.fanxan.foodmarket.R
import com.fanxan.foodmarket.model.response.login.LoginResponse
import com.fanxan.foodmarket.ui.MainActivity
import com.fanxan.foodmarket.ui.auth.AuthActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_signin.*

class SigninFragment : Fragment(), SignInContract.View {


    private lateinit var presenter: SigninPresenter
    var progressBarDialog: Dialog? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signin, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter = SigninPresenter(this)

//        if (!FoodMarket.getApp().getToken().isNullOrEmpty()) {
//            val home = Intent(activity, MainActivity::class.java)
//            startActivity(home)
//            activity?.finish()
//        }
        initDummy()
        initView()
        btnSignUp.setOnClickListener {
            val signUp = Intent(activity, AuthActivity::class.java)
            signUp.putExtra("page_request", 2)
            startActivity(signUp)
        }
        btnSignIn.setOnClickListener {


            val email = et_email.text.toString()
            val password = et_password.text.toString()

            if (email.isEmpty()) {
                et_email.error = "Silahkan Masukkan Email Anda"
                et_email.requestFocus()
            } else if (password.isEmpty()) {
                et_password.error = "Silahkan Masukkan Password Anda"
                et_password.requestFocus()
            } else {
                presenter.submitLogin(email, password)
            }
        }
    }

    override fun onLoginSuccess(loginResponse: LoginResponse) {
        FoodMarket.getApp().setToken(loginResponse.accessToken)
        val gson = Gson()
        val json = gson.toJson(loginResponse.user)
        FoodMarket.getApp().setUser(json)
        val home = Intent(activity, MainActivity::class.java)
        startActivity(home)
        activity?.finish()
        Toast.makeText(activity, "BERHASIL MASUK", Toast.LENGTH_LONG).show()
    }

    override fun onLoginFailed(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show()
    }

    private fun initDummy() {
        et_email.setText("fan@gmail.com")
        et_password.setText("12345678")
    }

    private fun initView() {
        progressBarDialog = Dialog(requireContext())
        val dialogLayout = layoutInflater.inflate(R.layout.dialog_loader, null)
        progressBarDialog?.let {
            it.setContentView(dialogLayout)
            it.setCancelable(false)
            it.window?.setBackgroundDrawableResource(android.R.color.transparent)
        }
    }

    override fun showLoading() {
        progressBarDialog?.show()
    }

    override fun dismissLoading() {
        progressBarDialog?.dismiss()
    }
}