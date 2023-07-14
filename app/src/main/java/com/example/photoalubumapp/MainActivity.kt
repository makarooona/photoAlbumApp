package com.example.photoalubumapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
                    NextPic()
                }
            }
        }
    }
}

@Composable
fun NextPic(){
    var currentPic by remember { mutableStateOf(1 ) }

    when (currentPic) {
        1 -> {
            PhotoAlbum(
                drawableResourceId = R.drawable.lemon_tree,
                title = R.string.lemon_tree,
                year = R.string.lemon_tree_2015_davinci,
                nextClick = { currentPic++ }
            ) { currentPic = 9 }
        }
        2-> {
            PhotoAlbum(
                drawableResourceId = R.drawable.lemon_squeeze,
                title = R.string.squeezed_lemon,
                year = R.string.squeezed_lemon_2018_vangoch,
                nextClick = { currentPic++ }
            ) { currentPic = 1 }
        }
        3-> {
            PhotoAlbum(
                drawableResourceId = R.drawable.lemon_tree,
                title = R.string.squeezed_lemon,
                year = R.string.squeezed_lemon_2018_vangoch,
                nextClick = { currentPic++ }
            ) { currentPic-- }
        }
    }
}

@Composable
fun PhotoAlbum(
    drawableResourceId: Int,
    title: Int,
    year: Int,
    nextClick: () -> Unit,
    prevClick: () -> Unit
){

    Column(
        modifier = Modifier.fillMaxSize(),horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ){
        Spacer(modifier= Modifier.height(40.dp))

        Image(
            painter = painterResource(drawableResourceId),
            contentDescription = null,modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        )
        Text(
                text = stringResource(title),
                modifier = Modifier.padding(12.dp),color = colorScheme.primary)
        Text(
                text = stringResource(year),
                modifier = Modifier.padding(12.dp),color = colorScheme.primary)
        Row{
            Button(
                onClick = {nextClick()},
            modifier = Modifier.padding(20.dp)) {
                Text(
                    text = stringResource(R.string.next_photo))
            }
            Button(
                onClick =  {prevClick()},
                modifier = Modifier.padding(20.dp)) {
                Text(
                    text= stringResource(R.string.previous_photo))
             }
            }
        }
    }


@Preview(showBackground = true)
@Composable
fun PhotoAlbumPreview() {
    PhotoAlubumAppTheme {
        NextPic()
    }
}