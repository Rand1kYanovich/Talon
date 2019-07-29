package ru.codeoverflow.talon.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CalendarView
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
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
        val arrayDirections = viewModelCoupon.getDirectionArray()
        val calendarView: CalendarView = rootView.findViewById(R.id.calendarView)
        val spinnerDirection = rootView.findViewById<Spinner>(R.id.spinnerDirection)
        val spinnerDoctor = rootView.findViewById<Spinner>(R.id.spinnerDoctor)
        arrayDirections.observe(viewLifecycleOwner, Observer {
            val adapterDirections = ArrayAdapter<String>(context!!, R.layout.simple_spinner_item, arrayDirections.value)
            adapterDirections.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
            spinnerDirection.adapter = adapterDirections

        })
       calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
           val yearE = year + 1
           date = "$yearE|$month|$dayOfMonth"
       }

        spinnerDirection.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                direction = arrayDirections.value!![position]
                val arrayDoctors = viewModelCoupon.getDoctorsArray(direction)
                arrayDoctors.observe(viewLifecycleOwner, Observer {
                    val adapterDoctors =
                        ArrayAdapter<String>(context!!, R.layout.simple_spinner_item, arrayDoctors.value!!)
                    adapterDoctors.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                    spinnerDoctor.adapter = adapterDoctors
                    spinnerDoctor.onItemSelectedListener = object:AdapterView.OnItemSelectedListener{
                        override fun onNothingSelected(parent: AdapterView<*>?) {}

                        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                            doctor = arrayDoctors.value!![position]
                        }

                    }
                })
            }

        }
        return rootView
    }
}