package com.samsung.android.baseball

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.samsung.android.baseball.databinding.FragmentGameWonBinding

//import com.samsung.android.baseball.databinding.FragmentGameWonBinding

class GameWonFragment : Fragment() {
    private val args: GameWonFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /*
        val binding: FragmentGameWonBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_game_won, container, false)

         */
        val binding = FragmentGameWonBinding.inflate(inflater, container, false)

        binding.numsText.text = "You guessed the number in %d times.".format(args.count)
        binding.tryButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                R.id.action_gameWonFragment_to_titleFragment
            )
        )
        return binding.root
    }
}