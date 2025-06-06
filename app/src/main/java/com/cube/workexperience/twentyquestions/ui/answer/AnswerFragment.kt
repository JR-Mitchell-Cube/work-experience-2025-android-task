package com.cube.workexperience.twentyquestions.ui.answer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.cube.workexperience.twentyquestions.databinding.FragmentAnswerBinding

class AnswerFragment : Fragment() {

    private var binding: FragmentAnswerBinding? = null
    private val viewModel by viewModels<AnswerViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentAnswerBinding.inflate(inflater, container, false)
        this.binding = binding

        populateUi(binding)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeState()
    }

    private fun populateUi(binding: FragmentAnswerBinding) {
        // Empty
    }

    private fun observeState() {
        viewModel.text.observe(viewLifecycleOwner) { text ->
            binding?.textAnswer?.text = text
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}