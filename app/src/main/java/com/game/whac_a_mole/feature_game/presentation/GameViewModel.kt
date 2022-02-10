package com.game.whac_a_mole.feature_game.presentation

import android.animation.ValueAnimator
import android.view.animation.LinearInterpolator
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Random

class GameViewModel : ViewModel() {

	private val _indexVisibleMole: MutableLiveData<Int> = MutableLiveData(10)
	val indexVisibleMole: LiveData<Int> = _indexVisibleMole

	private val _time: MutableLiveData<Int> = MutableLiveData(30)
	val time: LiveData<Int> = _time

	private val _counter: MutableLiveData<Int> = MutableLiveData(0)
	val counter: LiveData<Int> = _counter

	private val lookOutMolesList: List<Int> = (0..30).map { Random().nextInt(9) }

	init {
		ValueAnimator().apply {
			setIntValues(0, 66)
			addUpdateListener {
				setUpdateAnimatorListener(it)
			}
			interpolator = LinearInterpolator()
			duration = 33000L
			start()
		}
	}

	fun plusCount() {
		val count = _counter.value ?: 0
		_counter.value = count + 1
	}

	private fun setUpdateAnimatorListener(valueAnimator: ValueAnimator) {
		val tickCount = valueAnimator.animatedValue as Int
		_time.value = 33 - tickCount / 2
		when {
			tickCount > 6 && tickCount % 2 == 0 -> {
				_indexVisibleMole.value = 10
			}

			tickCount > 6 && tickCount % 2 == 1 -> {
				_indexVisibleMole.value = lookOutMolesList[(tickCount - 6) / 2]
			}
		}
	}
}