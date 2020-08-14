package ru.cutepool.egeikt.screens

import androidx.fragment.app.Fragment
import ru.cutepool.egeikt.screens.workout.WorkoutFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class WorkoutScreen() : SupportAppScreen() {
        override fun getFragment(): Fragment? {
            return WorkoutFragment.newInstance()
        }
    }
}