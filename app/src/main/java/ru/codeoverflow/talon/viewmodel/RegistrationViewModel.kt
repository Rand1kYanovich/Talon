package ru.codeoverflow.talon.viewmodel

import android.util.Log
import android.widget.EditText
import androidx.lifecycle.ViewModel


class RegistrationViewModel : ViewModel() {


    fun setRegistrationClickListener(etPassword: EditText, etPhoneNumber: EditText) {
        val password = etPassword.text.toString()
        Log.e("Number", etPhoneNumber.text.toString())
    }

    fun setPersonInfoClickListener(etName: EditText, etFamily: EditText, etPatronymic: EditText) {

        val name = etName.text.toString()
        val family = etFamily.text.toString()
        val patronymic = etPatronymic.text.toString()


    }


}