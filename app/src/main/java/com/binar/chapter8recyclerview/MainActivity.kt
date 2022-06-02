package com.binar.chapter8recyclerview

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.binar.chapter8recyclerview.data.GetAllNewsResponseItem
import com.binar.chapter8recyclerview.ui.theme.Chapter8recyclerviewTheme
import com.binar.chapter8recyclerview.ui.theme.Shapes
import com.binar.chapter8recyclerview.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Chapter8recyclerviewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val newsViewModel : NewsViewModel = viewModel(modelClass = NewsViewModel::class.java)
                    val datanews by newsViewModel.dataState.collectAsState()
                    Column(Modifier.fillMaxSize().padding(20.dp)) {
                        val context = LocalContext.current

                        Button(onClick = {
                            context.startActivity(Intent(context, StaffActivity::class.java))
                        }) {
                            Text(text = "STAFF")
                        }
                        LazyColumn{
                            if (datanews.isEmpty()){
                                item {

                                }
                            }

                            items(datanews){

                                Greeting(news = it)

                            }
                        }

                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(news : GetAllNewsResponseItem) {
    val context = LocalContext.current

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)) {

        Card(shape = RoundedCornerShape(10.dp),  elevation = 10.dp, modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clickable {

                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("news", news)
                context.startActivity(intent)

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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Chapter8recyclerviewTheme {
        //Greeting("", "", "", "", "", "", "", "", "")
    }
}