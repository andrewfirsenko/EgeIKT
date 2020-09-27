package ru.cutepool.egeikt.screens.workout

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_workout.view.*
import ru.cutepool.egeikt.R
import ru.cutepool.egeikt.RouterViewModelFactory
import ru.cutepool.egeikt.activities.main.MainViewModel
import ru.cutepool.egeikt.helper.CiceroneHelper

class WorkoutFragment : Fragment() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_workout, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnBeginTask = view.frg_workout__btn_begin_task
        btnBeginTask.setOnClickListener {
            Log.d("M_WorkoutFragment", "toTaskScreen() click button")
            mainViewModel.toTaskScreen()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initViewModel()
    }

    private fun initViewModel() {
        val mainViewModelFactory = RouterViewModelFactory(CiceroneHelper.router())
        mainViewModel = requireActivity().run {
            ViewModelProvider(this, mainViewModelFactory)
                .get(MainViewModel::class.java)
        }
    }

    companion object {
        fun newInstance(): WorkoutFragment = WorkoutFragment()
    }
}
