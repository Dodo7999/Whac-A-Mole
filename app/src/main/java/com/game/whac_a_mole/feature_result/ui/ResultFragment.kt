package com.game.whac_a_mole.feature_result.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.game.whac_a_mole.databinding.FragmentResultBinding
import com.game.whac_a_mole.feature_game.ui.GameFragment
import com.game.whac_a_mole.feature_start.ui.StartFragment
import com.game.whac_a_mole.getBestScore
import com.game.whac_a_mole.navigator
import com.game.whac_a_mole.setBestScore

class ResultFragment : Fragment() {

	lateinit var binding: FragmentResultBinding

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		binding = FragmentResultBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		bindData()
	}
}