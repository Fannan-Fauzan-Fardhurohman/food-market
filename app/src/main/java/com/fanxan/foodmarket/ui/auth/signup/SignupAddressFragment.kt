package com.fanxan.foodmarket.ui.auth.signup

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.fanxan.foodmarket.FoodMarket
import com.fanxan.foodmarket.R
import com.fanxan.foodmarket.model.request.RegisterRequest
import com.fanxan.foodmarket.model.response.login.LoginResponse
import com.fanxan.foodmarket.ui.auth.AuthActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_signup_address.*

class SignupAddressFragment : Fragment(), SignUpContract.View {

    private lateinit var data: RegisterRequest
    lateinit var presenter: SignupPresenter
    var progressDialog: Dialog? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_signup_address, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        presenter = SignupPresenter(this)

        data = arguments?.getParcelable<RegisterRequest>("data")!!
        initDummy()
        initListener()
        initView()
    }

    private fun initListener() {
        btnSignUpNow.setOnClickListener {
            var phone = et_phoneNumber.text.toString()
            var address = et_address.text.toString()
            var houseNumber = et_houseNo.text.toString()
            var city = et_city.text.toString()

            data.let {
                it.address = address
                it.city = city
                it.houseNumber = houseNumber
                it.phoneNumber = phone
            }

            if (phone.isNullOrEmpty()) {
                et_phoneNumber.error = "Silahkan masukkan nomor telepon"
                et_phoneNumber.requestFocus()
            } else if (address.isNullOrEmpty()) {
                et_address.error = "Silahkan masukkan alamat"
                et_address.requestFocus()
            } else if (houseNumber.isNullOrEmpty()) {
                et_houseNo.error = "Silahkan masukkan nomor rumah"
                et_houseNo.requestFocus()
            } else if (city.isNullOrEmpty()) {
                et_city.error = "Silahkan masukkan kota"
                et_city.requestFocus()
            } else {
                presenter.submitRegister(data, it)
            }

        }
    }

    private fun initDummy() {
        et_phoneNumber.setText("082222222")
        et_address.setText("Jalan Jendral Sudirman")
        et_houseNo.setText("155")
        et_city.setText("Bandung Barat")
    }

    override fun onRegisterSuccess(loginResponse: LoginResponse, view: View) {
        FoodMarket.getApp().setToken(loginResponse.accessToken)
        val gson = Gson()
        val json = gson.toJson(loginResponse.user)
        FoodMarket.getApp().setUser(json)

        if (data.filePath == null) {
            Navigation.findNavController(view)
                .navigate(R.id.action_signup_success, null)
            (activity as AuthActivity).toolbarSignUpSuccess()
        } else {
            presenter.submitPhotoRegister(data.filePath!!, view)
        }
    }

    override fun onRegisterPhotoSuccess(view: View) {
        Navigation.findNavController(view)
            .navigate(R.id.action_signup_success, null)
        (activity as AuthActivity).toolbarSignUpSuccess()

    }

    override fun onRegisterFailed(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    private fun initView() {
        progressDialog = Dialog(requireContext())
        val dialogLayout = layoutInflater.inflate(R.layout.dialog_loader, null)
        progressDialog?.let {
            it.setContentView(dialogLayout)
            it.setCancelable(false)
            it.window?.setBackgroundDrawableResource(android.R.color.transparent)
        }
    }

    override fun showLoading() {
        progressDialog?.show()
    }

    override fun dismissLoading() {
        progressDialog?.dismiss()
    }
}