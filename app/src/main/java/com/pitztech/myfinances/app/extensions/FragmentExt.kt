package com.pitztech.myfinances.extensions

import androidx.fragment.app.Fragment

fun Fragment.isViewLive(): Boolean{
    return this.isAdded && this.view != null
}