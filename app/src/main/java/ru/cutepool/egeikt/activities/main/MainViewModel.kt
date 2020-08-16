package ru.cutepool.egeikt.activities.main

import android.util.Log
import androidx.lifecycle.*
import ru.cutepool.egeikt.BackViewModel
import ru.cutepool.egeikt.helper.CiceroneHelper
import ru.cutepool.egeikt.screens.Screens
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainViewModel(private val router: Router) : BackViewModel(router), LifecycleObserver {

    private lateinit var navigator: SupportAppNavigator
    private val navHolder = CiceroneHelper.navHolder()

    fun toTaskScreen() {
        router.navigateTo(Screens.TaskScreen())
    }

    fun createNavigationScreen() {
        router.newRootChain(Screens.NavigationScreen())
    }

    fun setNavigator(navigator: SupportAppNavigator) {
        this.navigator = navigator
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun setNavigator() {
        Log.d("M_MainViewModel", "ON_RESUME lifecycle")
        navHolder.setNavigator(navigator)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private fun removeNavigator() {
        Log.d("M_MainViewModel", "ON_PAUSE lifecycle")
        navHolder.removeNavigator()
    }
}
