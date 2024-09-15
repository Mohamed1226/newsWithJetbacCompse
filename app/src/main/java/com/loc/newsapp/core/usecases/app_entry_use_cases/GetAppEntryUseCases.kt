package com.loc.newsapp.core.usecases.app_entry_use_cases

import com.loc.newsapp.core.data_manager.AppManger
import kotlinx.coroutines.flow.Flow

class GetAppEntryUseCases(private val localUserSetting: AppManger) {

     fun invoke(): Flow<Boolean> {
        return localUserSetting.readUserSetting()
    }
}