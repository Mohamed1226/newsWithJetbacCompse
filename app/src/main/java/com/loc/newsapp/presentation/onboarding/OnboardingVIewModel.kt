package com.loc.newsapp.presentation.onboarding

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loc.newsapp.core.usecases.app_entry_use_cases.AppEntryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class OnboardingVIewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
) : ViewModel() {


    fun saveEntrySetting() {
        viewModelScope.launch {
            appEntryUseCases.saveUserSettingUseCases.saveData()
        }
    }





}