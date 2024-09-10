package com.loc.newsapp.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.loc.newsapp.presentation.common.AppButton
import com.loc.newsapp.presentation.onboarding.component.ImageWithTitles
import com.loc.newsapp.presentation.onboarding.component.ImageWithTitlesPreview
import com.loc.newsapp.presentation.onboarding.components.PagerIndicator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen( viewModel: OnboardingVIewModel = hiltViewModel()) {

viewModel.readUserSetting()
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement  = Arrangement.SpaceBetween) {
        val pageState: PagerState = rememberPagerState(initialPage = 0, pageCount = { pages.size })
        val scope = rememberCoroutineScope()
        val buttonState = remember {
            derivedStateOf {
                when (pageState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    else -> listOf("Back", "Get started")
                }
            }
        }

        HorizontalPager(pageState) { index ->
            ImageWithTitles(page = pages[index])
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .navigationBarsPadding(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            PagerIndicator(pagesSize = pages.size, selectedPage = pageState.currentPage)
            Row {
                if (buttonState.value[0].isNotEmpty())
                    AppButton(title = buttonState.value[0], color = Color.Transparent, onClicked = {
                        scope.launch {
                            pageState.animateScrollToPage(page = pageState.currentPage - 1)
                        }
                    })
                AppButton(title = buttonState.value[1], onClicked = {
                    if (pageState.currentPage == pages.size - 1) {
                        viewModel.saveEntrySetting()
                    } else {
                        scope.launch {
                            pageState.animateScrollToPage(page = pageState.currentPage + 1)
                        }
                    }

                })

            }
        }
        Spacer(modifier = Modifier.height(1.dp))
    }
}
