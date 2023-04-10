package com.fanxan.foodmarket.ui.detail

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.fanxan.foodmarket.R
import kotlinx.android.synthetic.main.layout_toolbar.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun toolbarPayment() {
        toolbar.visibility= View.VISIBLE
        toolbar.title = "Payment"
        toolbar.subtitle = "You deserve better meal"
        toolbar.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_000, null)
        toolbar.setNavigationOnClickListener{
            onBackPressed()
        }
    }
    fun toolbarDetail(){
        toolbar.visibility = View.GONE
    }
}