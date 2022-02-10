package com.game.whac_a_mole.feature_result.ui

import com.game.whac_a_mole.R
import com.game.whac_a_mole.feature_game.ui.GameFragment
import com.game.whac_a_mole.feature_start.ui.StartFragment
import com.game.whac_a_mole.getBestScore
import com.game.whac_a_mole.navigator
import com.game.whac_a_mole.setBestScore

private const val SCORE = "SCORE"

private var userSeesResultScreen = false

fun ResultFragment.bindData() {
	bindText()
	bindNavigateButton()
}

private fun ResultFragment.bindText() {
	val currentScore = getCurrentScore()
	var bestScore = getBestScore() ?: 0

	if (bestScore < currentScore) {
		bestScore = currentScore
		setBestScore(currentScore)
	}

	with(binding) {
		bestResult.text = getBestScoreString(bestScore)
		currentResult.text = getCurrentScoreString(currentScore)
	}
}

private fun ResultFragment.bindNavigateButton() {
	with(binding) {
		menu.setOnClickListener {
			if (userSeesResultScreen) {
				userSeesResultScreen = true
			} else {
				navigator.goToFragment(StartFragment())
			}
		}
		playAgain.setOnClickListener {
			navigator.goToFragment(GameFragment())
		}
	}
}

private fun ResultFragment.getBestScoreString(bestScore: Int) =
	getString(R.string.best_score) + " = " + bestScore.toString()

private fun ResultFragment.getCurrentScoreString(currentScore: Int) =
	getString(R.string.current_score) + " = " + currentScore.toString()

private fun ResultFragment.getCurrentScore() = arguments?.getInt(SCORE) ?: 0
