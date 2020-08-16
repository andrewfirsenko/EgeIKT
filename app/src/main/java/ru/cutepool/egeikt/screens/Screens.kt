package ru.cutepool.egeikt.screens

import androidx.fragment.app.Fragment
import ru.cutepool.egeikt.screens.archive.ArchiveFragment
import ru.cutepool.egeikt.screens.navigation.NavigationFragment
import ru.cutepool.egeikt.screens.statistics.StatisticsFragment
import ru.cutepool.egeikt.screens.workout.WorkoutFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen


class Screens {
    class WorkoutScreen() : SupportAppScreen() {
        override fun getFragment(): Fragment? {
            return WorkoutFragment.newInstance()
        }
    }

    class NavigationScreen() : SupportAppScreen() {
        override fun getFragment(): Fragment? {
            return NavigationFragment.newInstance()
        }
    }

    class ArchiveScreen() : SupportAppScreen() {
        override fun getFragment(): Fragment? {
            return ArchiveFragment.newInstance()
        }
    }

    class StatisticsScreen() : SupportAppScreen() {
        override fun getFragment(): Fragment? {
            return StatisticsFragment.newInstance()
        }
    }
}
