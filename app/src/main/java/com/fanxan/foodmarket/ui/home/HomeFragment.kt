package com.fanxan.foodmarket.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fanxan.foodmarket.R
import com.fanxan.foodmarket.model.dummy.HomeModel
import com.fanxan.foodmarket.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), HomeAdapter.ItemAdapterCallback {

    private var foodList: ArrayList<HomeModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initDataDummy()
        var adapter = HomeAdapter(foodList, this)
        var layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        rcList.layoutManager = layoutManager
        rcList.adapter = adapter


        val sectionPagerAdapter = SectionPagerAdapter(
            childFragmentManager
        )
        viewPager.adapter = sectionPagerAdapter
        tabLayout.setupWithViewPager(viewPager)

    }

    fun initDataDummy() {
        foodList = ArrayList()
        foodList.add(HomeModel("Martabak Telor", "", 5f))
        foodList.add(HomeModel("Hot Dog", "", 3f))
        foodList.add(HomeModel("Burger", "", 1.5f))
    }

    override fun onClick(v: View, data: HomeModel) {
        val detail = Intent(activity, DetailActivity::class.java)
        startActivity(detail)
    }

}