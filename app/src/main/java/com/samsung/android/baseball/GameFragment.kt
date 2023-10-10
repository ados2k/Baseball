package com.samsung.android.baseball

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.samsung.android.baseball.databinding.FragmentGameBinding

class GameFragment : Fragment() {
    private lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(requireActivity()).get(GameViewModel::class.java)

        /*
        var binding: FragmentGameBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)

         */
        val binding = FragmentGameBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        binding.inputButton.setOnClickListener {
            if (viewModel.checkNums()) {
                view?.findNavController()?.navigate(
                    GameFragmentDirections.actionGameFragmentToGameWonFragment(
                        viewModel.count.value!!
                    )
                )
            } else if (viewModel.count.value!! >= 10) {
                view?.findNavController()?.navigate(
                    GameFragmentDirections.actionGameFragmentToGameOverFragment(
                        viewModel.getComNumbers()
                    )
                )
            }
        }

        return binding.root
    }
}