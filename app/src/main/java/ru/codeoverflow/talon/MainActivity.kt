package ru.codeoverflow.talon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.codeoverflow.talon.util.FragmentUtil
import ru.codeoverflow.talon.view.RegistrationFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FragmentUtil.replace(supportFragmentManager, R.id.content, RegistrationFragment.newInstance())

    }


}