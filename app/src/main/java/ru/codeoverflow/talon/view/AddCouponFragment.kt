package ru.codeoverflow.talon.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.add_coupon_fragment.*
import ru.codeoverflow.talon.R
import ru.codeoverflow.talon.viewmodel.CouponViewModel

class AddCouponFragment : Fragment() {

    private val viewModelCoupon: CouponViewModel by lazy {
        ViewModelProviders.of(activity!!).get(CouponViewModel::class.java)
    }

    private var doctor = ""
    private var direction = ""
    private var date = ""
    private var time = "8:00-14:00"


    companion object {
        fun newInstance() = AddCouponFragment()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: View = inflater.inflate(R.layout.add_coupon_fragment, container, false)
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val yearE = year + 1
            date = "$yearE|$month|$dayOfMonth"
            Log.e("Date", date)
        }
        return rootView
    }
}