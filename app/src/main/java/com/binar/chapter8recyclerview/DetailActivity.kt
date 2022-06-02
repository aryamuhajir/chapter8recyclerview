package com.binar.chapter8recyclerview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.binar.chapter8recyclerview.data.GetAllNewsResponseItem
import com.binar.chapter8recyclerview.ui.theme.Chapter8recyclerviewTheme

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Chapter8recyclerviewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val data = intent.getParcelableExtra<GetAllNewsResponseItem>("news") as GetAllNewsResponseItem
                    Greeting2(data)
                }
            }
        }
    }
}

@Composable
fun Greeting2(news : GetAllNewsResponseItem) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(20.dp),horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = rememberImagePainter(data = news.image), contentDescription = "gambar")
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = news.title, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text(text = news.createdAt, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text(text = news.author, fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text(text = news.description, fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.White)


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    Chapter8recyclerviewTheme {
    }
}