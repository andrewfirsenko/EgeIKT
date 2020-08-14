package ru.cutepool.egeikt.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.cutepool.egeikt.activities.main.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startMainActivity()
    }

    private fun startMainActivity() {
        MainActivity.start(this, intent.extras)
    }
}