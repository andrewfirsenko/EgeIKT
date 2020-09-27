package ru.cutepool.egeikt.activities.main

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import ru.cutepool.egeikt.R
import ru.cutepool.egeikt.RouterViewModelFactory
import ru.cutepool.egeikt.helper.CiceroneHelper
import ru.terrakok.cicerone.android.support.SupportAppNavigator


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()

        viewModel.createNavigationScreen()
    }

    private fun initViewModel() {
        val viewModelFactory = RouterViewModelFactory(CiceroneHelper.router())
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        val navigator = SupportAppNavigator(this, supportFragmentManager, CONTAINER)
        viewModel.setNavigator(navigator)

        lifecycle.addObserver(viewModel)
    }

    companion object {
        const val CONTAINER = R.id.act_main__content_frame

        @JvmStatic
        fun start(activityFrom: Activity, extras: Bundle? = null) {
            val intent = Intent(activityFrom, MainActivity::class.java)
            if (extras != null) {
                intent.putExtras(extras)
            }
            activityFrom.startActivity(intent)
            activityFrom.finish()
        }
    }
}
