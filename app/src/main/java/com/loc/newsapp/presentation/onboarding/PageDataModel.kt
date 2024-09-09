package com.loc.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.loc.newsapp.R

data class Page(
    val title: String,
    val desc: String,
    @DrawableRes val image: Int
)


val pages = listOf(
    Page(
        title = "onboarding title screen 1",
        desc = "jello in news app this is a good description for all news in the world",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "onboarding title screen 1",
        desc = "jello in news app this is a good description for all news in the world",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "onboarding title screen 1",
        desc = "jello in news app this is a good description for all news in the world",
        image = R.drawable.onboarding3
    ),
)