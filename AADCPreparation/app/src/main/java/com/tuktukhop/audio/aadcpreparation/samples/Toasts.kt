package com.tuktukhop.audio.aadcpreparation.samples

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.tuktukhop.audio.aadcpreparation.R

fun showToast(context: Context){
    val toast = Toast.makeText(context, "Test toast", Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.TOP, 0 , 0)
        toast.show()
}

fun customToast(context: Context, layoutInflater: LayoutInflater){
    val layout: View = layoutInflater.inflate(R.layout.custom_toast, null)

    val text: TextView = layout.findViewById(R.id.text)
    text.text = "This is a custom toast"
    with (Toast(context)) {
        setGravity(Gravity.CENTER_VERTICAL, 0, 0)
        duration = Toast.LENGTH_LONG
        view = layout
        show()
    }
}