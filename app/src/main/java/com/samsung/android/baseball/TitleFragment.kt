package com.samsung.android.baseball

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.samsung.android.baseball.databinding.FragmentTitleBinding

//import com.samsung.android.baseball.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {
    private val viewModel: GameViewModel by activityViewModels()

    //private lateinit var viewModel: GameViewModel
    //private val viewModel: GameViewModel by activityViewModels()
    //private val viewModel: GameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_main, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return menuItem.onNavDestinationSelected(findNavController())
            }
        }, viewLifecycleOwner)

        //viewModel = ViewModelProvider(requireActivity()).get(GameViewModel::class.java)
        viewModel.resetGame()

        /*
        val binding: FragmentTitleBinding =
            DataBindingUtil.inflate(
                inflater, R.layout.fragment_title,
                container, false
            )
        */
        val binding = FragmentTitleBinding.inflate(inflater, container, false)

        binding.playButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(
                R.id.action_titleFragment_to_gameFragment
            )
        )
        return binding.root
    }
}