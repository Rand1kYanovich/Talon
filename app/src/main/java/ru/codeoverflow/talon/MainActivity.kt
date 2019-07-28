package ru.codeoverflow.talon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import ru.codeoverflow.talon.util.FragmentUtil
import ru.codeoverflow.talon.util.SharedUtil
import ru.codeoverflow.talon.view.RegistrationFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContentView(R.layout.activity_main)
        SharedUtil.init()
        FragmentUtil.replace(supportFragmentManager, R.id.content, RegistrationFragment.newInstance())

    }


}