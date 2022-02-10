package com.game.whac_a_mole.feature_game.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.game.whac_a_mole.MainActivity
import com.game.whac_a_mole.R
import com.game.whac_a_mole.databinding.FragmentGameBinding
import com.game.whac_a_mole.feature_game.presentation.GameViewModel
import com.game.whac_a_mole.feature_result.ui.ResultFragment
import com.game.whac_a_mole.navigator

class GameFragment : Fragment() {

	lateinit var binding: FragmentGameBinding

	private lateinit var viewModel: GameViewModel

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		binding = FragmentGameBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

		bindData(viewModel)
	}
}