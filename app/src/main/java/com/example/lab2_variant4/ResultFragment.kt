package com.example.lab2_variant4

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class ResultFragment : Fragment(R.layout.fragment_result) {

    private val viewModel: SharedViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvResult: TextView = view.findViewById(R.id.tvResult)
        val btnCancel: Button = view.findViewById(R.id.btnCancel)

        viewModel.selectedLanguage.observe(viewLifecycleOwner) { language ->
            tvResult.text = language
        }

        btnCancel.setOnClickListener {
            viewModel.clearData()
            parentFragmentManager.popBackStack()
        }
    }
}