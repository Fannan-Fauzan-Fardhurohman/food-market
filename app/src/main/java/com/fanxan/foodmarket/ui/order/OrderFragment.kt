package com.fanxan.foodmarket.ui.order

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.fanxan.foodmarket.R
import com.fanxan.foodmarket.model.response.transaction.Data
import com.fanxan.foodmarket.model.response.transaction.TransactionResponse
import kotlinx.android.synthetic.main.fragment_orders.include_toolbar
import kotlinx.android.synthetic.main.fragment_orders.ll_empty
import kotlinx.android.synthetic.main.fragment_orders.ll_tab
import kotlinx.android.synthetic.main.fragment_orders.tabLayout
import kotlinx.android.synthetic.main.fragment_orders.viewPager
import kotlinx.android.synthetic.main.layout_toolbar.view.toolbar

class OrderFragment : Fragment(), OrderContract.View {
    lateinit var presenter: OrderPresenter
    var progressDialog: Dialog? = null
    var inprogressList: ArrayList<Data>? = ArrayList()
    var pastOrdersList: ArrayList<Data>? = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_orders, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        presenter = OrderPresenter(this)
        presenter.getTransaction()
    }

    private fun initView() {
        progressDialog = Dialog(requireContext())
        val dialogLayout = layoutInflater.inflate(R.layout.dialog_loader, null)
        progressDialog?.let {
            it.setContentView(dialogLayout)
            it.setCancelable(false)
            it.window?.setBackgroundDrawableResource(android.R.color.transparent)
        }
        include_toolbar.toolbar.title = "Your Orders"
        include_toolbar.toolbar.subtitle = "Wait for the best meal"

    }

    override fun onTransactionSuccess(transactionResponse: TransactionResponse) {
        if (transactionResponse.data.isNullOrEmpty()) {
            ll_empty.visibility = View.VISIBLE
            ll_tab.visibility = View.GONE
            include_toolbar.visibility = View.GONE
        } else {
            for (a in transactionResponse.data.indices) {
                if (transactionResponse.data[a].status.equals("ON_DELIVERY", true)
                    || transactionResponse.data[a].status.equals("PENDING", true)
                ) {
                    inprogressList?.add(transactionResponse.data[a])
                } else if (transactionResponse.data[a].status.equals("DELIVERY", true) ||
                    transactionResponse.data[a].status.equals("CANCELLED", true)
                    || transactionResponse.data[a].status.equals("SUCCESS", true)
                ) {
                    pastOrdersList?.add(transactionResponse.data[a])
                }
            }
            val sectionPagerAdapter = SectionPagerAdapter(
                childFragmentManager
            )
            sectionPagerAdapter.setData(inprogressList, pastOrdersList)
            viewPager.adapter = sectionPagerAdapter
            tabLayout.setupWithViewPager(viewPager)
        }

    }

    override fun onTransactionFailed(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        progressDialog?.show()
    }

    override fun dismissLoading() {
        progressDialog?.dismiss()
    }
}