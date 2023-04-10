package com.fanxan.foodmarket.ui.home

import com.fanxan.foodmarket.base.BasePresenter
import com.fanxan.foodmarket.base.BaseView
import com.fanxan.foodmarket.model.response.login.LoginResponse

interface HomeContract {

    interface View : BaseView {
        fun onHomeSuccess(loginResponse: LoginResponse)
        fun onHomeFailed(message: String)
    }

    interface Presenter : HomeContract, BasePresenter {
        fun getHpme()
    }

}