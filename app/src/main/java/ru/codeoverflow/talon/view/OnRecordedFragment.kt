package ru.codeoverflow.talon.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.codeoverflow.talon.R

class OnRecordedFragment: Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView:View = inflater.inflate(R.layout.on_recorded_fragment,container,false)
        return rootView
    }
}