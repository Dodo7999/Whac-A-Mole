package com.game.whac_a_mole

import android.content.Context
import androidx.fragment.app.Fragment

private const val MAX_SCORE = "MAX RECORD"
private const val SCORE = "SCORE"

fun Fragment.getBestScore() =
	(this.activity as MainActivity)
		.getSharedPreferences(MAX_SCORE, Context.MODE_PRIVATE)
		?.getInt(SCORE, 0)

fun Fragment.setBestScore(currentResult: Int) =
	(this.activity as MainActivity)
		.getSharedPreferences(MAX_SCORE, Context.MODE_PRIVATE)
		?.edit()
		?.putInt(SCORE, currentResult)
		?.apply()

val Fragment.navigator
	get() = (this.activity as MainActivity).navigator