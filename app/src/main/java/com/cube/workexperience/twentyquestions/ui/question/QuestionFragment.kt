package com.cube.workexperience.twentyquestions.ui.question

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.cube.workexperience.twentyquestions.databinding.FragmentQuestionBinding
import kotlinx.coroutines.launch

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
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getState().collect(::onStateUpdated)
        }
    }

    private fun onStateUpdated(state: QuestionViewModel.ViewState) {
        binding?.apply {
            textMainTitle.apply {
                text = state.mainTitle
                isVisible = state.mainTitle != null
            }
            textSubtitle.apply {
                text = state.subtitle
                isVisible = state.subtitle != null
            }
            textHeadingPreviousRound.apply {
                text = state.previousRoundTitle
                isVisible = state.previousRoundTitle != null
            }
            textHeadingEditbox.apply {
                text = state.editBoxTitle
                isVisible = state.editBoxTitle != null
            }
            textInputLayout.apply {
                hint = state.editBoxHint
                setAutofillHints(state.editBoxAutofillHint)
                isVisible = state.editBoxHint != null
            }
            buttonSubmit.apply {
                isEnabled = state.submitButtonEnabled
                setOnClickListener {
                    viewModel.onSubmit(
                        text = binding?.textInputEdittext?.text?.toString().orEmpty(),
                        mode = state.submitMode
                    )
                    // Clear the text box
                    binding?.textInputEdittext?.setText("")
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}