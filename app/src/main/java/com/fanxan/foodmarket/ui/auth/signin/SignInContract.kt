package com.fanxan.foodmarket.ui.auth.signin

import com.fanxan.foodmarket.base.BasePresenter
import com.fanxan.foodmarket.base.BaseView
import com.fanxan.foodmarket.model.response.login.LoginResponse

interface SignInContract {

    interface View : BaseView {
        fun onLoginSuccess(loginResponse: LoginResponse)
        fun onLoginFailed(message: String)
    }

    interface Presenter : SignInContract, BasePresenter {
        fun submitLogin(email: String, password: String)
    }

}