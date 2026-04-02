package com.example.lab2_variant4

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class InputFragment : Fragment(R.layout.fragment_input) {
    private val viewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val spinner: Spinner = view.findViewById(R.id.spinnerLanguages)
        val btnOk: Button = view.findViewById(R.id.btnOk)
        val languages = arrayOf("Java", "Kotlin", "Python", "C++", "C#")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, languages)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        btnOk.setOnClickListener {
            val selected = spinner.selectedItem.toString()
            viewModel.selectLanguage(selected)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, ResultFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}