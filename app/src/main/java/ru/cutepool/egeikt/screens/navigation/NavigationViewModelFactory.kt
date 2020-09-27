package ru.cutepool.egeikt.screens.navigation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router


class NavigationViewModelFactory(private val cicerone: Cicerone<Router>) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Cicerone::class.java)
            .newInstance(cicerone)
    }
}
