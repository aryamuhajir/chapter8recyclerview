package com.binar.chapter8recyclerview

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.binar.chapter8recyclerview.data.GetAllNewsResponseItem

@Composable
fun getNews(news : GetAllNewsResponseItem){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)) {
        Card(shape = RoundedCornerShape(10.dp),  elevation = 10.dp, modifier = Modifier
            .fillMaxWidth()
            .height(100.dp).clickable {


            }) {
            Row(
                Modifier
                    .fillMaxSize()
                    .padding(5.dp)) {
                Image(painter = rememberImagePainter(data = news.image), contentDescription = "gambar")
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 15.dp)) {
                    Text(text = news.title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Text(text = news.title, fontSize = 20.sp, fontWeight = FontWeight.Thin)
                    Text(text = news.author, fontSize = 20.sp, fontWeight = FontWeight.Bold)


                }

            }

        }

    }
}