package cnovaez.dev.foodapp.utils

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import cnovaez.dev.foodapp.R
import timber.log.Timber

/**
 ** Created by Carlos A. Novaez Guerrero on 29/12/2022 12:10
 ** cnovaez.dev@outlook.com
 **/

fun logError(msg: String, errTag: String = "Error") {
    Timber.tag(errTag).e(msg)
}

fun logInformation(msg: String, infoTag: String = "Info") {
    Timber.tag(infoTag).e(msg)
}

fun Activity.navigate(direction: NavDirections) {
    this.findNavController(R.id.navHost).navigate(direction)
}

fun Fragment.navigate(direction: NavDirections) {
    this.findNavController().navigate(direction)
}

fun showToast(context: Context, msg: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, msg, duration).show()
}