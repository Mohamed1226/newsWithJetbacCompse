package com.loc.newsapp

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loc.newsapp.core.usecases.app_entry_use_cases.AppEntryUseCases
import com.loc.newsapp.presentation.navgraph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases

) : ViewModel() {

    var showSplash by mutableStateOf(true)
        private set
    var startDestination by mutableStateOf(Route.AppStartNavigation.route)
        private set

    init {

        appEntryUseCases.getUserSettingUseCases.invoke().onEach { isSeen ->
            Log.d("TEST IS SEEN", isSeen.toString())
            startDestination = if (isSeen) {
                Route.NewsNavigation.route
            } else {
                Route.AppStartNavigation.route
            }
            delay(300)
            showSplash = false

        }.launchIn(viewModelScope)
    }

}