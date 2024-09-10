package com.loc.newsapp.core.data_manager

import kotlinx.coroutines.flow.Flow

interface AppManger {

    suspend fun saveUserSetting()
     fun readUserSetting() : Flow<Boolean>
}