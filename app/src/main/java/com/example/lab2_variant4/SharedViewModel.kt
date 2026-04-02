package com.example.lab2_variant4

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _selectedLanguage = MutableLiveData<String>()
    val selectedLanguage: LiveData<String> = _selectedLanguage

    fun selectLanguage(language: String) {
        _selectedLanguage.value = language
    }

    fun clearData() {
        _selectedLanguage.value = ""
    }
}