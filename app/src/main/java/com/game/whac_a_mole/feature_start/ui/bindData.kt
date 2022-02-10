package com.game.whac_a_mole.feature_start.ui

import com.game.whac_a_mole.R
import com.game.whac_a_mole.feature_game.ui.GameFragment
import com.game.whac_a_mole.getBestScore
import com.game.whac_a_mole.navigator

fun StartFragment.bindData() {
	bindText()
	bindNavigateButton()
}

private fun StartFragment.bindText() {
	binding.recordText.text = getBestScoreString()
	binding.rules.text = getGameRules()
}

private fun StartFragment.bindNavigateButton() {
	binding.fragmentStart.setOnClickListener {
		navigator.goToFragment(GameFragment())
	}
}

private fun StartFragment.getBestScoreString() =
	getString(R.string.best_score) + " = " + getBestScore()

private fun StartFragment.getGameRules() =
	getString(R.string.rules)