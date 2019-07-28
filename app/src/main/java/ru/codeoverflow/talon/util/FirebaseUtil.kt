package ru.codeoverflow.talon.util

import android.util.Log
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import ru.codeoverflow.talon.App
import ru.codeoverflow.talon.model.entity.Coupon

class FirebaseUtil {


    companion object {
        private fun getDatabase(): DatabaseReference = FirebaseDatabase.getInstance().reference


        fun setPhoneNumber() {
            Log.e("SprefUser",SharedUtil.getUser())
            Log.e("Firebase", getDatabase().toString())
            getDatabase().child("Users").child(SharedUtil.getUser()).child("phoneNumber").setValue(SharedUtil.getUser())
        }

        fun setName(name: String, family: String, patronymic: String) {
            getDatabase().child("Users").child(SharedUtil.getUser()).child("name").setValue("$name $family $patronymic")
        }

        fun setPassword(password: String) {
            getDatabase().child("Users").child(SharedUtil.getUser()).child("password").setValue(password)
        }

        fun setCoupon(coupon: Coupon){
            getDatabase().child("Users").child(SharedUtil.getUser()).child("coupons").child(coupon.couponNumber).child("couponNumber").setValue(coupon.couponNumber)
            getDatabase().child("Users").child(SharedUtil.getUser()).child("coupons").child(coupon.couponNumber).child("time").setValue(coupon.time)
            getDatabase().child("Users").child(SharedUtil.getUser()).child("coupons").child(coupon.couponNumber).child("date").setValue(coupon.date)
            getDatabase().child("Users").child(SharedUtil.getUser()).child("coupons").child(coupon.couponNumber).child("doctor").setValue(coupon.doctor)
            getDatabase().child("Users").child(SharedUtil.getUser()).child("coupons").child(coupon.couponNumber).child("direction").setValue(coupon.direction)
        }
    }
}