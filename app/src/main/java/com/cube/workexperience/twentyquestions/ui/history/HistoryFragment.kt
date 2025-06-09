package com.cube.workexperience.twentyquestions.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.cube.workexperience.twentyquestions.R
import com.cube.workexperience.twentyquestions.databinding.FragmentHistoryBinding
import com.cube.workexperience.twentyquestions.lib.decorator.InternalMarginDecorator
import kotlinx.coroutines.launch

class HistoryFragment : Fragment() {

    private var binding: FragmentHistoryBinding? = null
    private val viewModel by viewModels<HistoryViewModel>()
    private val adapter = HistoryAdapter()

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
        binding.root.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@HistoryFragment.adapter
            addItemDecoration(
                InternalMarginDecorator(
                    resources = resources,
                    verticalMarginDimenResId = R.dimen.padding_default
                )
            )
        }
    }

    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getMessages().collect { messages ->
                adapter.submitList(messages)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}