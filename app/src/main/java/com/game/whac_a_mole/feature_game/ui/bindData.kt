package com.game.whac_a_mole.feature_game.ui

import android.widget.ImageView
import androidx.core.view.isVisible
import com.game.whac_a_mole.feature_game.presentation.GameViewModel
import com.game.whac_a_mole.feature_result.ui.ResultFragment
import com.game.whac_a_mole.navigator

private const val SCORE = "SCORE"

fun GameFragment.bindData(viewModel: GameViewModel) {
	bindMole(viewModel)
	bindScoreText(viewModel)
	bindTimerText(viewModel)
}

private fun GameFragment.bindMole(viewModel: GameViewModel) {
	val moles = getListMole()

	moles.forEachIndexed { index, imageView ->
		imageView.setOnClickListener {
			viewModel.plusCount()
			imageView.hide()
		}
	}

	viewModel.indexVisibleMole.observe(viewLifecycleOwner, { index ->
		setActiveMole(index, moles)
	})
}

private fun GameFragment.bindScoreText(viewModel: GameViewModel) {
	viewModel.counter.observe(viewLifecycleOwner, {
		binding.count.text = it.toString()
	})
}

private fun GameFragment.bindTimerText(viewModel: GameViewModel) {
	viewModel.time.observe(viewLifecycleOwner, {
		binding.time.text = it.toString()
		if (it <= 0) {
			goToResultFragment(viewModel)
		}
	})
}

private fun GameFragment.getListMole(): List<ImageView> {
	val listMole: MutableList<ImageView> = mutableListOf()
	with(binding) {
		listMole.add(mole1)
		listMole.add(mole2)
		listMole.add(mole3)
		listMole.add(mole4)
		listMole.add(mole5)
		listMole.add(mole6)
		listMole.add(mole7)
		listMole.add(mole8)
		listMole.add(mole9)
	}
	return listMole
}

private fun setActiveMole(indexVisibleMole: Int, moles: List<ImageView>) {
	moles.forEachIndexed { index, imageView ->
		imageView.setVisibleAndClickable(indexVisibleMole, index)
	}
}

private fun GameFragment.goToResultFragment(viewModel: GameViewModel) {
	navigator.goToFragmentWithData(
		fragment = ResultFragment(),
		key = SCORE,
		data = viewModel.counter.value ?: 0
	)
}

private fun ImageView.setVisibleAndClickable(indexVisibleMole: Int, indexList: Int) {
	isClickable = indexList == indexVisibleMole
	isVisible = indexList == indexVisibleMole
}

private fun ImageView.hide(){
	isClickable = false
	isVisible = false
}