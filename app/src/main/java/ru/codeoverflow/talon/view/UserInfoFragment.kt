package ru.codeoverflow.talon.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import ru.codeoverflow.talon.R
import ru.codeoverflow.talon.util.FragmentUtil
import ru.codeoverflow.talon.viewmodel.RegistrationViewModel

class UserInfoFragment : Fragment() {

    private val viewModel: RegistrationViewModel by lazy {
        ViewModelProviders.of(activity!!).get(RegistrationViewModel::class.java)
    }

    companion object {
        fun newInstance() = UserInfoFragment()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: View = inflater.inflate(R.layout.user_info_fragment, container, false)
        val etName: EditText = rootView.findViewById(R.id.etName)
        val etFamily: EditText = rootView.findViewById(R.id.etFamily)
        val etPatronymic: EditText = rootView.findViewById(R.id.etPatronymic)
        val btnSubmit: Button = rootView.findViewById(R.id.btnSubmit)
        btnSubmit.setOnClickListener {
            viewModel.setPersonInfoClickListener(etName, etFamily, etPatronymic)
            FragmentUtil.replace(activity!!.supportFragmentManager, R.id.content, CouponsFragment.newInstance())
        }


        return rootView
    }
}