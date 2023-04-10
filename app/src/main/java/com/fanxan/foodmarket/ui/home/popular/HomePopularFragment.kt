package com.fanxan.foodmarket.ui.home.popular

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fanxan.foodmarket.R
import com.fanxan.foodmarket.model.dummy.HomeVerticalModel
import com.fanxan.foodmarket.ui.detail.DetailActivity
import com.fanxan.foodmarket.ui.home.newtaste.HomeNewTasteAdapter
import kotlinx.android.synthetic.main.fragment_home_new_taste.*

class HomePopularFragment : Fragment(), HomeNewTasteAdapter.ItemAdapterCallback {
    private var foodList: ArrayList<HomeVerticalModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_new_taste, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initDataDummy()
        var adapter = HomeNewTasteAdapter(foodList, this)
        var layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(activity)
        rcList.layoutManager = layoutManager
        rcList.adapter = adapter

    }

    fun initDataDummy() {
        foodList = ArrayList()
        foodList.add(HomeVerticalModel("Martabak Telor", "100000", "", 5f))
        foodList.add(HomeVerticalModel("Hot Dog", "50000", "", 3f))
        foodList.add(HomeVerticalModel("Burger", "50000", "", 1.5f))
    }

    override fun onClick(v: View, data: HomeVerticalModel) {
        val detail = Intent(activity, DetailActivity::class.java)
        startActivity(detail)
    }


}