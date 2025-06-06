package com.cube.workexperience.twentyquestions.ui.question

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.cube.workexperience.twentyquestions.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {

    private var binding: FragmentQuestionBinding? = null
    private val viewModel by viewModels<QuestionViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentQuestionBinding.inflate(inflater, container, false)
        this.binding = binding

        populateUi(binding)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeState()
    }

    private fun populateUi(binding: FragmentQuestionBinding) {
        // Empty
    }

    private fun observeState() {
        viewModel.text.observe(viewLifecycleOwner) { text ->
            binding?.textQuestion?.text = text
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}