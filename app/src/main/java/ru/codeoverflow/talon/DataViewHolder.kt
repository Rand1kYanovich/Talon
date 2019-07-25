package ru.codeoverflow.talon

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    val couponNumber: TextView = itemView.findViewById(R.id.tvCouponNumber)
    val time: TextView = itemView.findViewById(R.id.tvTime)
    val direction: TextView = itemView.findViewById(R.id.tvDirection)
    val doctor: TextView = itemView.findViewById(R.id.tvDate)
    val date:TextView = itemView.findViewById(R.id.tvDate)
    val store:TextView = itemView.findViewById(R.id.tvStore)
    val waitTalon:TextView = itemView.findViewById(R.id.tvWaitTalon)


}