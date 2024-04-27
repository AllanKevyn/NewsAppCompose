package com.example.newsappcompose.presentation.common

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.newsappcompose.R
import com.example.newsappcompose.domain.model.Article
import com.example.newsappcompose.domain.model.Source
import com.example.newsappcompose.ui.theme.NewsAppComposeTheme
import com.example.newsappcompose.util.Dimens.ArticleCardSize
import com.example.newsappcompose.util.Dimens.ExtraSmallPadding
import com.example.newsappcompose.util.Dimens.ExtraSmallPadding2
import com.example.newsappcompose.util.Dimens.SmallIconSize

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick: () -> Unit
) {

    val context = LocalContext.current

    Row(
        modifier = modifier.clickable { onClick() }
    ) {

        AsyncImage(
            modifier = Modifier
                .size(ArticleCardSize)
                .clip(MaterialTheme.shapes.medium),
            contentScale = ContentScale.Crop,
            model = ImageRequest.Builder(context).data(article.urlToImage).build(),
            contentDescription = null
        )

        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = ExtraSmallPadding)
                .height(ArticleCardSize)
        ) {
            Text(
                text = article.title,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
            ) {
                Text(
                    text = article.source.name,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.width(ExtraSmallPadding2))

                Icon(
                    painter = painterResource(id = R.drawable.time), contentDescription = null,
                    modifier = Modifier.size(SmallIconSize),
                    tint = Color.Gray
                )

                Spacer(modifier = Modifier.width(ExtraSmallPadding2))

                Text(
                    text = article.publishedAt,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun showArticleCardPreview() {
    NewsAppComposeTheme {
        ArticleCard(
            article = Article(
                "author allan",
                "content",
                "description",
                "2 hours",
                Source("id", "BBC"),
                "Titulo content content content content content content content content content content ",
                "",
                ""
            )
        ) {
        }
    }
}