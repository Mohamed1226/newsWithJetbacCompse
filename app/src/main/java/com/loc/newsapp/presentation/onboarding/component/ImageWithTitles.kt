package com.loc.newsapp.presentation.onboarding.component

import Dimens.largePadding
import Dimens.meduimPadding
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.loc.newsapp.R
import com.loc.newsapp.presentation.onboarding.Page
import com.loc.newsapp.presentation.onboarding.pages
import com.loc.newsapp.ui.theme.NewsAppTheme

@Composable
fun ImageWithTitles(
    page: Page,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier) {

        Image(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(.6f),
            painter = painterResource(id = page.image), contentDescription = "",
            contentScale = ContentScale.Crop
        )
        Spacer(modifier.height(meduimPadding))
        Title(title = page.title)
        Title(title = page.desc, fontWeight = FontWeight.Normal)
    }
}


@Composable
fun Title(title: String, modifier: Modifier = Modifier, fontWeight : FontWeight = FontWeight.Bold) {
    Text(
        title, style = MaterialTheme.typography.displaySmall.copy(fontWeight = fontWeight),
        color = colorResource(R.color.display_small),
        modifier = modifier.padding(horizontal = largePadding)
    )
}

@Preview(name = "prev",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun ImageWithTitlesPreview(){
    NewsAppTheme {
        ImageWithTitles(page = pages.first())
    }
}