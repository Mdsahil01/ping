package com.mdsahil.ping.data

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore by preferencesDataStore(name = "user_preferences")

val USER_NAME = stringPreferencesKey("user_name")
val ONBOARDING_COMPLETED = booleanPreferencesKey("onboarding_completed")