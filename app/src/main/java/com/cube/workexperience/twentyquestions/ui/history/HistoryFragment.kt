package com.cube.workexperience.twentyquestions.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.cube.workexperience.twentyquestions.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {

    private var binding: FragmentHistoryBinding? = null
    private val viewModel by viewModels<HistoryViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHistoryBinding.inflate(inflater, container, false)
        this.binding = binding

        populateUi(binding)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeState()
    }

    private fun populateUi(binding: FragmentHistoryBinding) {
        // Empty
    }

    private fun observeState() {
        viewModel.text.observe(viewLifecycleOwner) { text ->
            binding?.textHistory?.text = text
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}