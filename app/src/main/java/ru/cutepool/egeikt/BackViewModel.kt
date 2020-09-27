package ru.cutepool.egeikt

import androidx.lifecycle.ViewModel
import ru.terrakok.cicerone.Router

open class BackViewModel(private val router: Router) : ViewModel() {
    fun back() {
        router.exit()
    }
}
