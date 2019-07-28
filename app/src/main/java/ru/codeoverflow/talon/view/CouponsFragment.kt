package ru.codeoverflow.talon.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.codeoverflow.talon.DataAdapter
import ru.codeoverflow.talon.R
import ru.codeoverflow.talon.util.FragmentUtil

class CouponsFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: DataAdapter
    lateinit var btnAddCoupon:ImageView



    companion object {
        fun newInstance() = CouponsFragment()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: View = inflater.inflate(R.layout.coupons_fragment, container, false)

        btnAddCoupon = rootView.findViewById(R.id.btnAddCoupon)
        btnAddCoupon.setOnClickListener {
            FragmentUtil.replaceWithBackStack(activity!!.supportFragmentManager,R.id.content,AddCouponFragment.newInstance())
        }
        recyclerView = rootView.findViewById(R.id.recyclerView)
        layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager

        adapter = DataAdapter(ArrayList())
        recyclerView.adapter = adapter

        recyclerView.isNestedScrollingEnabled = false
        recyclerView.setHasFixedSize(true)




        return rootView
    }
}