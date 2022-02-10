package com.game.whac_a_mole.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.game.whac_a_mole.R

class Navigator(
	private val fragmentManager: FragmentManager
) {

	fun goToFragment(fragment: Fragment) {
		fragmentManager
			.beginTransaction()
			.replace(R.id.container, fragment)
			.commit()
	}

	fun goToFragmentWithData(fragment: Fragment, key: String, data: Int) {
		val bundle = Bundle()
		bundle.putInt(key, data)
		fragment.arguments = bundle

		goToFragment(fragment)
	}

	fun setInitialFragment(fragment: Fragment) {
		fragmentManager
			.beginTransaction()
			.add(R.id.container, fragment)
			.commit()
	}
}