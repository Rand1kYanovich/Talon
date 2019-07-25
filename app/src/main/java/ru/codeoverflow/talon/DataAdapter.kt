package ru.codeoverflow.talon

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.codeoverflow.talon.model.entity.Coupon

class DataAdapter constructor(private var couponList:ArrayList<Coupon>): RecyclerView.Adapter<DataViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val layoutView: View = LayoutInflater.from(parent.context).inflate(R.layout.coupon_item, parent, false)
        return DataViewHolder(layoutView)
    }

    override fun getItemCount(): Int {
        return couponList.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {

    }

    fun setList(list:ArrayList<Coupon>){
        couponList = list
        notifyDataSetChanged()
    }
}