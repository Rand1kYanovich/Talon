package ru.codeoverflow.talon.viewmodel

import android.util.Log
import android.widget.EditText
import androidx.lifecycle.ViewModel
import ru.codeoverflow.talon.util.FirebaseUtil
import ru.codeoverflow.talon.util.SharedUtil


class RegistrationViewModel : ViewModel() {


    fun setRegistrationClickListener(etPassword: EditText, etPhoneNumber: EditText) {
        val phoneNumber = etPhoneNumber.text.toString()
        val password = etPassword.text.toString()
        SharedUtil.setUser(phoneNumber)
        FirebaseUtil.setPhoneNumber()
        FirebaseUtil.setPassword(password)
        Log.e("Number", etPhoneNumber.text.toString())
    }

    fun setPersonInfoClickListener(etName: EditText, etFamily: EditText, etPatronymic: EditText) {

        val name = etName.text.toString()
        val family = etFamily.text.toString()
        val patronymic = etPatronymic.text.toString()

        FirebaseUtil.setName(name,family,patronymic)


    }


}