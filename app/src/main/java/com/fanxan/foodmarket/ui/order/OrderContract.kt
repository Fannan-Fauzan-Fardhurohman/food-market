package com.fanxan.foodmarket.ui.order

import com.fanxan.foodmarket.base.BasePresenter
import com.fanxan.foodmarket.base.BaseView
import com.fanxan.foodmarket.model.response.home.HomeResponse
import com.fanxan.foodmarket.model.response.login.LoginResponse
import com.fanxan.foodmarket.model.response.transaction.TransactionResponse

interface OrderContract {

    interface View : BaseView {
        fun onTransactionSuccess(transactionResponse: TransactionResponse)
        fun onTransactionFailed(message: String)
    }

    interface Presenter : OrderContract, BasePresenter {
        fun getTransaction()
    }

}