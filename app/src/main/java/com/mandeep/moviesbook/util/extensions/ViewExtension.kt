package com.mandeep.moviesbook.util.extensions

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import coil.load

/**
 * App Name: Movies Book
 * Package Name: com.mandeep.moviesbook.util.extensions
 * Author : Mandeep Singh
 * Email Id: officialmandeepsp@gmail.com
 * Date: Fri 31 Mar, 2023
 *
 **/

infix fun ImageView.setImage(url: String) {
    load(url)
}

infix fun View.onClick(click: () -> Unit) {
    setOnClickListener { click() }
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

infix fun String.generateImgUrl(imgUrl: String): String {
    return "https://openweathermap.org/img/w/$imgUrl.png"
}