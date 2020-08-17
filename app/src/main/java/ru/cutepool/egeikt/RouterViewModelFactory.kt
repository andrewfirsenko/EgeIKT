package ru.cutepool.egeikt

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.terrakok.cicerone.Router


class RouterViewModelFactory(private val router: Router) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Router::class.java)
                .newInstance(router)
    }

}


