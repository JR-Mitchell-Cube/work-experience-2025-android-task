package com.cube.workexperience.twentyquestions.ui.answer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AnswerViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is answer Fragment"
    }
    val text: LiveData<String> = _text
}