package com.example.newsappcompose.presentation.onboarding.components

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsappcompose.util.Dimens.BigPadding
import com.example.newsappcompose.util.Dimens.MediumPadding
import com.example.newsappcompose.util.Dimens.SmallPadding
import com.example.newsappcompose.domain.model.Page
import com.example.newsappcompose.domain.model.pages
import com.example.newsappcompose.ui.theme.NewsAppComposeTheme

@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page: Page
) {
    Column(modifier = Modifier) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.60f),
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(MediumPadding))
        Text(
            modifier = Modifier.padding(horizontal = BigPadding),
            text = page.title,
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = Color(android.graphics.Color.BLACK)
        )
        Text(
            modifier = Modifier.padding(horizontal = BigPadding),
            text = page.description,
            style = MaterialTheme.typography.bodyMedium,
            color = Color(android.graphics.Color.GRAY)
        )
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun onBoardingPreview() {

    NewsAppComposeTheme {
        OnBoardingPage(page = pages[0])
    }
}