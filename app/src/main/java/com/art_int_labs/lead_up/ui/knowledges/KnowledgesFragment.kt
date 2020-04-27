package com.art_int_labs.lead_up.ui.knowledges

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.art_int_labs.lead_up.R


class KnowledgesFragment : Fragment() {

    companion object {
        fun newInstance() = KnowledgesFragment()
    }

    private lateinit var viewModel: KnowledgesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.knowledges_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(KnowledgesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
