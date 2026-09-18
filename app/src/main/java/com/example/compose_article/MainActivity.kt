package com.example.compose_article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Paragraph
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_article.ui.theme.Compose_ArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose_ArticleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Article(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Paragraph(title: String, firstParagraph: String, secondParagraph: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 140.dp, start = 10.dp, end = 10.dp, bottom = 10.dp),
        verticalArrangement = Arrangement.Top,
        ) {
        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = firstParagraph,
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 10.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = secondParagraph,
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 10.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun Article(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.header_image)
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.align(alignment = Alignment.TopStart)
            )
            Paragraph(title = stringResource(R.string.title), firstParagraph = stringResource(R.string.firstParagraph), secondParagraph = stringResource(
                R.string.secondParagraph
            ))
        }
}

@Preview(showBackground = true)
@Composable
fun ArticlePreview() {
    Compose_ArticleTheme {
        Article()
    }
}