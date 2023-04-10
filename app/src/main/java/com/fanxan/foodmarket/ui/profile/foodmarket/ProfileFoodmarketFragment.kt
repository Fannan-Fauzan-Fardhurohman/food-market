package com.fanxan.foodmarket.ui.profile.foodmarket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fanxan.foodmarket.R
import com.fanxan.foodmarket.model.dummy.ProfileMenuModel
import com.fanxan.foodmarket.ui.profile.ProfileMenuAdapter
import kotlinx.android.synthetic.main.fragment_profile_account.*

class ProfileFoodmarketFragment : Fragment(),ProfileMenuAdapter.ItemAdapterCallback {
    private var menuArrayList: ArrayList<ProfileMenuModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_account, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        initDataDummy()

        var adapter = ProfileMenuAdapter(menuArrayList,this)
        var layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(activity)
        rcList.layoutManager = layoutManager
        rcList.adapter = adapter
    }

    fun initDataDummy() {
        menuArrayList = ArrayList()
        menuArrayList.add(ProfileMenuModel("Rate Apps"))
        menuArrayList.add(ProfileMenuModel("Help Center"))
        menuArrayList.add(ProfileMenuModel("Privacy & Policy"))
        menuArrayList.add(ProfileMenuModel("Term & Condition"))
    }

    override fun onClick(v: View, data: ProfileMenuModel) {
        TODO("Not yet implemented")
    }
}