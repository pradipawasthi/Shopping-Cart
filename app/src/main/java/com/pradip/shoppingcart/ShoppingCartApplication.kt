package com.pradip.shoppingcart

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp

class ShoppingCartApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}