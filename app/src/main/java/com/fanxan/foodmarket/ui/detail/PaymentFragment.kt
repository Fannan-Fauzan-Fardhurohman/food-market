package com.fanxan.foodmarket.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.fanxan.foodmarket.FoodMarket
import com.fanxan.foodmarket.R
import com.fanxan.foodmarket.model.response.home.Data
import com.fanxan.foodmarket.model.response.login.User
import com.fanxan.foodmarket.utils.Helpers.formatPrice
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_payment.*

class PaymentFragment : Fragment() {
    var total: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as DetailActivity).toolbarPayment()

        var data = arguments?.getParcelable<Data>("data")
        initView(data)
//
    }

    private fun initView(data: Data?) {
        data?.let {
            tvTitle.text = it.name
            tvPrice.formatPrice(it.price.toString())
            Glide.with(requireContext())
                .load(it.picturePath)
                .into(ivPoster)

            tvNameItem.text = it.name
            tvHarga.formatPrice(it.price.toString())
            if (!it.price.toString().isNullOrEmpty()) {
                var totalTax = it.price?.div(10)
                tvTax.formatPrice(totalTax.toString())

                total = it.price!! + totalTax!! + 50000
                tvTotal.formatPrice(total.toString())
            } else {
                tvPrice.text = "IDR.0"
                tvTotal.text = "IDR.0"
                tvTax.text = "IDR.0"
                total = 0
            }

        }

        val user = FoodMarket.getApp().getUser()
        var userResponse = Gson().fromJson(user, User::class.java)
        tvName.text = userResponse?.name
        tvPhoneNo.text = userResponse?.phoneNumber
        tvAddress.text = userResponse?.address
        tvCity.text = userResponse?.city
        btnCheckout.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_payment_success)
        }

    }
}