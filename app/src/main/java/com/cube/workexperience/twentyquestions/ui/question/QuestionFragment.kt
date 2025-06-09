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

/**
 * Android [Fragment] for the user asking questions.
 * In Android development, a Fragment can be a screen or a section of a screen with its own layout
 * and lifecycle.
 * For instance, fragments may be used for different tabs on the main screen, or for information
 * sheets that come up from the bottom of the screen.
 */
class QuestionFragment : Fragment() {

    private var binding: FragmentQuestionBinding? = null
    private val viewModel by viewModels<QuestionViewModel>()

    /**
     * The View of the fragment is the actual hierarchy of layout elements that will show in the
     * Fragment.
     * The [onCreateView] is a method in the Android system, inherited from [Fragment], which
     * creates this view hierarchy.
     * The `override` keyword demonstrates that this is an override of an inherited method.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // This creates the views, along with convenient accessors to them, from fragment_question.xml
        val binding = FragmentQuestionBinding.inflate(inflater, container, false)
        this.binding = binding

        populateUi(binding)

        return binding.root
    }

    /**
     * Once the view has been created and registered in the Android system, this method is called.
     * This overrides a method inherited from [Fragment].
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeState()
    }

    /**
     * This method initially configures the view hierarchy of this fragment.
     * If there needs to be any initial configuration of the UI, do it here!
     */
    private fun populateUi(binding: FragmentQuestionBinding) {
        // Empty
    }

    /**
     * This method observes for changes in the state of the viewmodel and ensures that the UI is
     * updated accordingly.
     */
    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getState().collect(::onStateUpdated)
        }
    }

    /**
     * This method updates the UI of the fragment based on a given view state.
     * @param state The view state to update the UI to reflect.
     */
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

    /**
     * The Android system may destroy the view hierarchy, even if the [Fragment] itself still
     * exists.
     * In this case, we free up all references to the views we created earlier on in [onCreateView],
     * to ensure that we're not trying to modify views that have already been destroyed.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}