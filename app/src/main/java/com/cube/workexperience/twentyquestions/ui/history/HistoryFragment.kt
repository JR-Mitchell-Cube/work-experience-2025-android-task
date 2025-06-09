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

/**
 * Android [Fragment] for viewing the history of the game.
 * In Android development, a Fragment can be a screen or a section of a screen with its own layout
 * and lifecycle.
 * For instance, fragments may be used for different tabs on the main screen, or for information
 * sheets that come up from the bottom of the screen.
 */
class HistoryFragment : Fragment() {

    private var binding: FragmentHistoryBinding? = null
    private val viewModel by viewModels<HistoryViewModel>()
    private val adapter = HistoryAdapter()

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
        // This creates the views, along with convenient accessors to them, from fragment_history.xml
        val binding = FragmentHistoryBinding.inflate(inflater, container, false)
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

    /**
     * This method observes for changes in the state of the viewmodel and ensures that the UI is
     * updated accordingly.
     */
    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getMessages().collect { messages ->
                adapter.submitList(messages)
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