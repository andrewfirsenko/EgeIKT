package ru.cutepool.egeikt.screens.workout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.cutepool.egeikt.R

class WorkoutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_workout, container, false)

    companion object {
        fun newInstance(): WorkoutFragment = WorkoutFragment()
    }
}