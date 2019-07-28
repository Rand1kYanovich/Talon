package ru.codeoverflow.talon.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.firebase.FirebaseApp
import ru.codeoverflow.talon.R
import ru.codeoverflow.talon.util.FragmentUtil
import ru.codeoverflow.talon.viewmodel.RegistrationViewModel

class RegistrationFragment: Fragment() {

    companion object{
        fun newInstance()=RegistrationFragment()
    }

    private val viewModel:RegistrationViewModel by lazy {
        ViewModelProviders.of(activity!!).get(RegistrationViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView:View = inflater.inflate(R.layout.registration_fragment,container,false)
        val etPhoneNumber: EditText = rootView.findViewById(R.id.etPhoneNumber)
        val etPassword: EditText = rootView.findViewById(R.id.etPassword)
        val btnSubmit: Button = rootView.findViewById(R.id.btnContinue)
        btnSubmit.setOnClickListener {
            viewModel.setRegistrationClickListener(etPassword,etPhoneNumber)
            FragmentUtil.replace(activity!!.supportFragmentManager,R.id.content,UserInfoFragment.newInstance())
        }


        return rootView
    }
}