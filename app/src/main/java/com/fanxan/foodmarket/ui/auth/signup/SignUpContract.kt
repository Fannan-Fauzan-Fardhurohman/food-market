package com.fanxan.foodmarket.ui.auth.signup

import android.net.Uri
import android.view.View
import com.fanxan.foodmarket.base.BasePresenter
import com.fanxan.foodmarket.base.BaseView
import com.fanxan.foodmarket.model.request.RegisterRequest
import com.fanxan.foodmarket.model.response.login.LoginResponse
import com.fanxan.foodmarket.ui.auth.signin.SignInContract

interface SignUpContract {
    interface View : BaseView {
        fun onRegisterSuccess(loginResponse: LoginResponse,view:android.view.View)
        fun onRegisterPhotoSuccess(view:android.view.View)
        fun onRegisterFailed(message: String)
    }

    interface Presenter : SignInContract, BasePresenter {
        fun submitRegister(registerRequest: RegisterRequest, view: android.view.View)
        fun submitPhotoRegister(filePath: Uri, view: android.view.View)
    }
}