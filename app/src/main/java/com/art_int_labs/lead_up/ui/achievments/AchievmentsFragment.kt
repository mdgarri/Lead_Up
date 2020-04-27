package com.art_int_labs.lead_up.ui.achievments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.art_int_labs.lead_up.R


class AchievmentsFragment : Fragment() {

    companion object {
        fun newInstance() = AchievmentsFragment()
    }

    private lateinit var viewModel: AchievmentsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.achievments_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AchievmentsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
