package com.example.photoalubumapp

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.photoalubumapp.ui.theme.PhotoAlubumAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotoAlubumAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PhotoAlbumLayout()
                }
            }
        }
    }
}

@Composable
fun PhotoAlbumLayout(){
    Column(
        modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.flower),
            contentDescription = null,modifier = Modifier.padding(40.dp).fillmaxsize
        )

    }
    }



@Preview(showBackground = true)
@Composable
fun PhotoAlbumPreview() {
    PhotoAlubumAppTheme {
        PhotoAlbumLayout()
    }
}