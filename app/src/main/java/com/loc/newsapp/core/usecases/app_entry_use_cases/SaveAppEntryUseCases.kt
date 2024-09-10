package com.loc.newsapp.core.usecases.app_entry_use_cases

import com.loc.newsapp.core.data_manager.AppManger

class SaveAppEntryUseCases (private val localUserSetting : AppManger){

   suspend fun saveData(){
       localUserSetting.saveUserSetting()
   }
}