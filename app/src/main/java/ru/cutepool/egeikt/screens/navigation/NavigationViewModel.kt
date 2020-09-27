package ru.cutepool.egeikt.screens.navigation

import android.util.Log
import androidx.lifecycle.*
import ru.cutepool.egeikt.BackViewModel
import ru.cutepool.egeikt.screens.Screens
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator


class NavigationViewModel(cicerone: Cicerone<Router>)
    : BackViewModel(cicerone.router), LifecycleObserver {

    private lateinit var navigator: SupportAppNavigator
    private val navHolder = cicerone.navigatorHolder
    private val router = cicerone.router

    private var title = MutableLiveData<String>()

    fun getTitle(): LiveData<String> = title

    fun createWorkoutScreen() {
        Log.d("M_NavigationViewModel", "createWorkoutScreen()")
        title.value = "Тренировка"
        router.newRootChain(Screens.WorkoutScreen())
    }

    fun replaceWorkoutScreen() {
        Log.d("M_NavigationViewModel", "replaceWorkoutScreen()")
        title.value = "Тренировка"
        router.replaceScreen(Screens.WorkoutScreen())
    }

    fun replaceArchiveScreen() {
        title.value = "Архив"
        router.replaceScreen(Screens.ArchiveScreen())
    }

    fun replaceStatisticsScreen() {
        title.value = "Статистика"
        router.replaceScreen(Screens.StatisticsScreen())
    }

    fun setNavigator(navigator: SupportAppNavigator) {
        this.navigator = navigator
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun setNavigator() {
        Log.d("M_NavigationViewModel", "ON_RESUME")
        navHolder.setNavigator(navigator)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private fun removeNavigator() {
        Log.d("M_NavigationViewModel", "ON_PAUSE")
        navHolder.removeNavigator()
    }

    companion object {
        fun getCicerone(): Cicerone<Router> = Cicerone.create()
    }
}
