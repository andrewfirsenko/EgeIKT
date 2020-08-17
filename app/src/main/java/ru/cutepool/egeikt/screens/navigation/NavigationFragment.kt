package ru.cutepool.egeikt.screens.navigation

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragment_navigation.*
import kotlinx.android.synthetic.main.fragment_navigation.view.*
import ru.cutepool.egeikt.R
import ru.cutepool.egeikt.RouterViewModelFactory
import ru.cutepool.egeikt.activities.main.MainViewModel
import ru.cutepool.egeikt.app.App
import ru.cutepool.egeikt.helper.CiceroneHelper
import ru.cutepool.egeikt.screens.workout.WorkoutFragment
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class NavigationFragment : Fragment(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawer: DrawerLayout
    private lateinit var title: TextView
    private lateinit var viewModel: NavigationViewModel
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_navigation, container, false)
        title = view.frg_navigation__title_toolbar
        val toolbar = view.frg_navigation__toolbar

        drawer = view.frg_navigation__drawer
        val navigationView = view.frg_navigation__navigation_view

        val drawerToggle: ActionBarDrawerToggle = ActionBarDrawerToggle(activity,
            drawer, toolbar, R.string.drawer_open, R.string.drawer_close)

        drawerToggle.isDrawerIndicatorEnabled = true
        drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener(this)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initViewModels()

        viewModel.createWorkoutScreen()
    }

    private fun initViewModels() {
        val viewModelFactory = NavigationViewModelFactory(NavigationViewModel.getCicerone())
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(NavigationViewModel::class.java)
        val mainViewModelFactory = RouterViewModelFactory(CiceroneHelper.router())
        mainViewModel = requireActivity().run {
            ViewModelProvider(this, mainViewModelFactory)
                .get(MainViewModel::class.java)
        }

        val navigator = SupportAppNavigator(requireActivity(), childFragmentManager, CONTAINER)
        viewModel.setNavigator(navigator)

        lifecycle.addObserver(viewModel)

        val liveData = viewModel.getTitle()
        liveData.observe(this, Observer {
            title.text = it
        })
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu__workout -> viewModel.replaceWorkoutScreen()
            R.id.menu__archive -> viewModel.replaceArchiveScreen()
            R.id.menu__statistics -> viewModel.replaceStatisticsScreen()
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    companion object {
        private const val CONTAINER = R.id.frg_navigation__content_frame

        fun newInstance(): NavigationFragment = NavigationFragment()
    }
}
