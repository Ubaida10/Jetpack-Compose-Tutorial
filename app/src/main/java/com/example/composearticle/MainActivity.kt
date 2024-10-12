package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
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
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                        ComposeArticle(
                            heading = stringResource(R.string.heading),
                            paragraph1 = stringResource(R.string.para1),
                            paragraph2 = stringResource(R.string.para2),
                            modifier = Modifier.padding(innerPadding)
                        )

                }
            }
        }
    }
}


@Composable
fun ComposeArticle(heading: String, paragraph1: String, paragraph2: String, modifier: Modifier = Modifier) {
    Column {
        ComposeArticleImage(modifier)
        ComposeArticleText(heading, paragraph1, paragraph2,modifier)
    }
}

@Composable
private fun ComposeArticleImage(modifier: Modifier=Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.Inside,
        modifier = Modifier.padding(5.dp)
    )
}

@Composable
private fun ComposeArticleText(heading: String, paragraph1: String, paragraph2: String, modifier: Modifier = Modifier) {
    Text(
        text = heading,
        textAlign = TextAlign.Justify,
        fontSize = 24.sp,
        modifier = Modifier
            .padding(16.dp)
    )
    Text(
        text = paragraph1,
        textAlign = TextAlign.Justify,
        modifier=Modifier
            .padding(start = 16.dp, end = 16.dp)
    )
    Text(
        text = paragraph2,
        textAlign = TextAlign.Justify,
        modifier = Modifier
            .padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        ComposeArticle(
            heading = stringResource(R.string.heading),
            paragraph1 = stringResource(R.string.para1),
            paragraph2 = stringResource(R.string.para2),
        )
    }
}