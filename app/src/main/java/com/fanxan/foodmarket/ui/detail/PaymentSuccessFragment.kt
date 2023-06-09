package com.fanxan.foodmarket.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fanxan.foodmarket.R
import kotlinx.android.synthetic.main.fragment_payment_success.btn_my_order
import kotlinx.android.synthetic.main.fragment_payment_success.btn_other_food

class PaymentSuccessFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment_success, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as DetailActivity).toolbarDetail()

        btn_other_food.setOnClickListener {
            requireActivity().finish()
        }

        btn_my_order.setOnClickListener {
            requireActivity().finish()
        }
    }
}