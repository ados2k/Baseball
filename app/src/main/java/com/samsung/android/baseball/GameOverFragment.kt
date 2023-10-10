package com.samsung.android.baseball

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.samsung.android.baseball.databinding.FragmentGameOverBinding

class GameOverFragment : Fragment() {
    private val args: GameOverFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*
        val binding: FragmentGameOverBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_game_over, container, false)
         */
        val binding = FragmentGameOverBinding.inflate(inflater, container, false)

        binding.numsText.text = "The numbers are %s.".format(args.numbers)
        binding.tryButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                R.id.action_gameOverFragment_to_titleFragment
            )
        )
        return binding.root
    }
}