package com.loc.newsapp.data.app_manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.loc.newsapp.core.data_manager.AppManger
import com.loc.newsapp.core.constants.UserSettings.ENTRY_APP_IS_SHOWN
import com.loc.newsapp.core.constants.UserSettings.USER_SETTINGS
import com.loc.newsapp.data.app_manager.UserSettingsPref.entryAppIsShown
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AppMangerImpl(private val context: Context) : AppManger {
    override suspend fun saveUserSetting() {
        context.dataPref.edit { userSettings -> userSettings[entryAppIsShown] = true }
    }

    override fun readUserSetting(): Flow<Boolean> {
        return context.dataPref.data.map { settings ->
            settings[entryAppIsShown] ?: false
        }
    }


}

private val Context.dataPref: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

object UserSettingsPref {
    val entryAppIsShown = booleanPreferencesKey(name = ENTRY_APP_IS_SHOWN)
}