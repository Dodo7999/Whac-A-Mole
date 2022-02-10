package com.game.whac_a_mole

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.game.whac_a_mole.feature_start.ui.StartFragment
import com.game.whac_a_mole.navigation.Navigator

class MainActivity : AppCompatActivity() {

	val navigator = Navigator(supportFragmentManager)

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		navigator.setInitialFragment(StartFragment())
	}
}