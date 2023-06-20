package com.fanxan.foodmarket.ui.order.pastorder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fanxan.foodmarket.R
import com.fanxan.foodmarket.model.dummy.ProfileMenuModel
import com.fanxan.foodmarket.model.response.transaction.Data
import com.fanxan.foodmarket.ui.order.inprogress.InprogressAdapter
import com.fanxan.foodmarket.ui.profile.ProfileMenuAdapter
import kotlinx.android.synthetic.main.fragment_inprogress.rcList
import kotlinx.android.synthetic.main.fragment_profile_account.*

class PastorderFragment : Fragment(),PastordersAdapter.ItemAdapterCallback {
    private var adapter: PastordersAdapter? = null
    var pastOrderList: ArrayList<Data>? = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pastorders, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        pastOrderList = arguments?.getParcelableArrayList("data")
        if (!pastOrderList.isNullOrEmpty()) {
            adapter = PastordersAdapter(pastOrderList!!, this)
            val layoutManager = LinearLayoutManager(activity)
            rcList.layoutManager = layoutManager
            rcList.adapter = adapter
        }
    }

    override fun onClick(v: View, data: Data) {
        Toast.makeText(activity, "coba klik", Toast.LENGTH_SHORT).show()
    }

}