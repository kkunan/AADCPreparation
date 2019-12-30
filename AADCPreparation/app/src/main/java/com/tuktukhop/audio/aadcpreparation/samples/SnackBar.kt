package com.tuktukhop.audio.aadcpreparation.samples

import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.snackbar.Snackbar

fun showSnackBar(layout: CoordinatorLayout, text: String, action: () -> Unit){
    val bar = Snackbar.make(layout, text, Snackbar.LENGTH_INDEFINITE)
    bar.setAction("Click") { action() }
    bar.show()
}