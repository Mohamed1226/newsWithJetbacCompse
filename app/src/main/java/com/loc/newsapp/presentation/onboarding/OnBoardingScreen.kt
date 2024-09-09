package com.loc.newsapp.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.loc.newsapp.presentation.onboarding.component.ImageWithTitles
import com.loc.newsapp.presentation.onboarding.component.ImageWithTitlesPreview

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen() {


    Column (modifier = Modifier.fillMaxSize()){
        val pageState: PagerState = rememberPagerState(initialPage = 0, pageCount = { pages.size })

        val buttonState = remember {
            derivedStateOf {
                when (pageState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    else -> listOf("Back", "Get started")
                }
            }
        }

        HorizontalPager(pageState) {index ->
            ImageWithTitles(page = pages[index])
        }
    }
}
