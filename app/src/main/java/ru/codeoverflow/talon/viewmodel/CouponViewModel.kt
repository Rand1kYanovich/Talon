package ru.codeoverflow.talon.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CouponViewModel : ViewModel() {

    var directions = MutableLiveData<List<String>>()
    var doctors = MutableLiveData<List<String>>()


    fun getDirectionArray(): LiveData<List<String>> {
        FirebaseDatabase.getInstance().reference.child("Doctors")
            .addValueEventListener(object : ValueEventListener {
                var arrayDirection = ArrayList<String>()

                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (data: DataSnapshot in dataSnapshot.children) {
                        if (data.exists()) {
                            arrayDirection.add(data.key.toString())
                        }
                    }
                    directions.value = arrayDirection
                }

                override fun onCancelled(p0: DatabaseError) {

                }

            })
        return directions
    }

    fun getDoctorsArray(direction: String):LiveData<List<String>> {
        FirebaseDatabase.getInstance().reference.child("Doctors").child(direction)
            .addValueEventListener(object : ValueEventListener {
                var arrayDirection = ArrayList<String>()

                override fun onCancelled(p0: DatabaseError) {

                }

                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (data: DataSnapshot in dataSnapshot.children) {
                        if (data.exists()) {
                            arrayDirection.add(data.key.toString())
                        }
                    }
                    doctors.value = arrayDirection

                }

            })
        return doctors
    }
}