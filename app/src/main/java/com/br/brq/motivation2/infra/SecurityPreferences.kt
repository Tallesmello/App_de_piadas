package com.br.brq.motivation2.infra

import android.content.Context
import android.content.SharedPreferences
import java.nio.channels.spi.AbstractSelectionKey

class SecurityPreferences(context: Context) {

    private val mSharedPreferences: SharedPreferences =
        context.getSharedPreferences("Piadas para alegrar seu dia.", Context.MODE_PRIVATE)

    fun storeString(key: String, value: String) {
        this.mSharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String) : String {
        return this.mSharedPreferences.getString(key, "") ?: ""
    }
}