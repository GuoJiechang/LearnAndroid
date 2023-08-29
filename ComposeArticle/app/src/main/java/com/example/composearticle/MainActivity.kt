package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArticleImage()
                    ArticleText(text1 = stringResource(R.string.article_title), text2 = stringResource(R.string.article_text2), text3 = stringResource(R.string.article_text3))
                }
            }
        }
    }
}

@Composable
fun ArticleImage(modifier: Modifier = Modifier)
{
    var image = painterResource(id = R.drawable.bg_compose_background)
    Image(
        painter = image,
        contentDescription = null,
        alignment = Alignment.TopCenter
        )
}

@Composable
fun ArticleText(text1: String, text2: String, text3: String, modifier: Modifier = Modifier)
{

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = text1,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = text2,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding( start = 16.dp, end = 16.dp)

        )
        Text(
            text = text3,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
       )
    }


}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        ArticleImage()
        ArticleText(text1 = stringResource(R.string.article_title), text2 = stringResource(R.string.article_text2), text3 = stringResource(R.string.article_text3))
    }
}