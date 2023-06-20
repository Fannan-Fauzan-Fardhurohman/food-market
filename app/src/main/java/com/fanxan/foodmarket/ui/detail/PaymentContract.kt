package com.fanxan.foodmarket.ui.detail

import com.fanxan.foodmarket.base.BasePresenter
import com.fanxan.foodmarket.base.BaseView
import com.fanxan.foodmarket.model.response.checkout.CheckoutResponse

interface PaymentContract {

    interface View : BaseView {
        fun onCheckoutSuccess(checkoutResponse: CheckoutResponse, view: android.view.View)
        fun onCheckoutFailed(message: String)
    }

    interface Presenter : PaymentContract, BasePresenter {
        fun getCheckout(FoodId:String, userId:String, quantity:String, total:String, view:android.view.View)
    }

}