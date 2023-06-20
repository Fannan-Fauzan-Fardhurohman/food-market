package com.fanxan.foodmarket.ui.order

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.fanxan.foodmarket.model.response.transaction.Data
import com.fanxan.foodmarket.ui.order.inprogress.InProgressFragment
import com.fanxan.foodmarket.ui.order.pastorder.PastorderFragment

class SectionPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    var inprogressList:ArrayList<Data>? = ArrayList()
    var pastprdersList:ArrayList<Data>? = ArrayList()


    var newTasteList: ArrayList<Data>? = ArrayList()
    var recommendedList: ArrayList<Data>? = ArrayList()
    var popularList: ArrayList<Data>? = ArrayList()
    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "In Progress"
            1 -> "Past Orders"
            else -> ""
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        val fragment: Fragment
        return when (position) {
            0 -> {
                fragment = InProgressFragment()
                val bundle = Bundle()
                bundle.putParcelableArrayList("data",inprogressList)
                fragment.arguments = bundle
                return fragment
            }
            1 -> {
                fragment = PastorderFragment()
                val bundle = Bundle()
                bundle.putParcelableArrayList("data",pastprdersList)
                fragment.arguments = bundle
                return fragment
            }
            else -> {
                fragment = InProgressFragment()
                val bundle = Bundle()
                bundle.putParcelableArrayList("data",inprogressList)
                fragment.arguments = bundle
                return fragment
            }
        }
    }

    fun setData(
        inprogressListParams:ArrayList<Data>?,
        pastOrderListParams:ArrayList<Data>?
    ) {
       inprogressList = inprogressListParams
        pastprdersList = pastOrderListParams
    }
}