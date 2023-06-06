package com.fanxan.foodmarket.ui.home.recommended

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fanxan.foodmarket.R
import com.fanxan.foodmarket.model.response.home.Data
import com.fanxan.foodmarket.ui.detail.DetailActivity
import com.fanxan.foodmarket.ui.home.newtaste.HomeNewTasteAdapter
import kotlinx.android.synthetic.main.fragment_home.rcList
import kotlinx.android.synthetic.main.fragment_home_new_taste.*


class HomeRecommendedFragment : Fragment(), HomeNewTasteAdapter.ItemAdapterCallback {

    private var recomendedList : ArrayList<Data>? = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_new_taste, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recomendedList = arguments?.getParcelableArrayList("data")

//        initDataDummy()
        var adapter = HomeNewTasteAdapter(recomendedList!!, this)
        var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
        rcList.layoutManager = layoutManager
        rcList.adapter = adapter
    }

//    fun initDataDummy() {
//        foodList = ArrayList()
//        foodList.add(HomeVerticalModel("Cherry Healthy","10000","",5f))
//        foodList.add(HomeVerticalModel("Burger Tamayo","50000","",4f))
//        foodList.add(HomeVerticalModel("Bakhwan Cihuy","70000","",4.5f))
//
//    }

    override fun onClick(v: View, data: Data) {
        val detail = Intent(activity, DetailActivity::class.java).putExtra("data", data)
        startActivity(detail)
    }

}