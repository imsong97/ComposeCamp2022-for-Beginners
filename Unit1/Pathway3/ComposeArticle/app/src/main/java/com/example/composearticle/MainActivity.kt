package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                Surface(color = MaterialTheme.colors.background) {
                    ComposeArticleApp()
                }
            }
        }
    }
}

@Composable
fun ComposeArticleApp() {
    val title = stringResource(id = R.string.title_jetpack_compose_tutorial)
    val shortDes = stringResource(id = R.string.compose_short_desc)
    val longDes = stringResource(id = R.string.compose_long_desc)
    val img = painterResource(id = R.drawable.bg_compose_background)

    ArticleCard(
        title = title,
        shortDescription = shortDes,
        longDescription = longDes,
        imagePainter = img
    )
}

@Composable
private fun ArticleCard(
    title: String,
    shortDescription: String,
    longDescription: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier,
) {
    Column {
        Image(
            painter = imagePainter,
            contentDescription = "Compose Image",
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
        )

        Text(
            text = title,
            fontSize = 24.sp,
            modifier = modifier
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp)
        )

        Text(
            text = shortDescription,
            modifier = modifier
                .padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )

        Text(
            text = longDescription,
            modifier = modifier
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp),
            textAlign = TextAlign.Justify
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val title = stringResource(id = R.string.title_jetpack_compose_tutorial)
    val shortDes = stringResource(id = R.string.compose_short_desc)
    val longDes = stringResource(id = R.string.compose_long_desc)
    val img = painterResource(id = R.drawable.bg_compose_background)

    ArticleCard(
        title = title,
        shortDescription = shortDes,
        longDescription = longDes,
        imagePainter = img
    )
}