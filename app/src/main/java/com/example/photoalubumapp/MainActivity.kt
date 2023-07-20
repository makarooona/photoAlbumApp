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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                contentDescription = R.string.mona_lisa_description.toString(),
                drawableResourceId = R.drawable.mona_lisa,
                title = R.string.mona_lisa_title,
                author = R.string.mona_lisa_painter,
                year = R.string.mona_lisa_year,
                nextClick = { currentPic++ },
                prevClick = { currentPic = 1}
            )
        }
        2-> {
            PhotoAlbum(
                contentDescription = R.string.the_girl_with_pearl_description.toString(),
                drawableResourceId = R.drawable.the_girl_with_a_pearl_parring,
                title = R.string.the_girl_with_pearl_title,
                author = R.string.the_girl_with_pearl_description,
                year = R.string.the_girl_with_pearl_year,
                nextClick = { currentPic++ },
                prevClick = { currentPic--}
            )
        }
        3-> {
            PhotoAlbum(
                contentDescription = R.string.guernica_description.toString(),
                drawableResourceId = R.drawable.guernica,
                title = R.string.guernica_title,
                author = R.string.guernica_painter,
                year = R.string.guernica_year,
                nextClick = { currentPic++ },
                prevClick = { currentPic--}
            )
        }
        4-> {
            PhotoAlbum(
                contentDescription = R.string.persistence_of_memory_description.toString(),
                drawableResourceId = R.drawable.persistenceofmemory,
                title = R.string.persistence_of_memory_title,
                author = R.string.persistence_of_memory_painter,
                year = R.string.persistence_of_memory_year,
                nextClick = { currentPic++ },
                prevClick = { currentPic-- }
            )
            }
        5-> {
            PhotoAlbum(
                contentDescription = R.string.the_birth_of_venus_description.toString(),
                drawableResourceId = R.drawable.sandro_botticelli,
                title = R.string.the_birth_of_venus_title,
                author = R.string.the_birth_of_venus_painter,
                year = R.string.the_birth_of_venus_year,
                nextClick = { currentPic++ },
                prevClick = { currentPic-- }
            )
        }
        6-> {
            PhotoAlbum(
                contentDescription = R.string.the_last_supper_description.toString(),
                drawableResourceId = R.drawable.the_last_supper,
                title = R.string.the_last_supper_title,
                author = R.string.the_last_supper_painter,
                year = R.string.the_last_supper_year,
                nextClick = { currentPic++ },
                prevClick = { currentPic-- }
            )
        }
        7-> {
            PhotoAlbum(
                contentDescription = R.string.the_night_watch_description.toString(),
                drawableResourceId = R.drawable.the_night_watch,
                title = R.string.the_night_watch_title,
                author = R.string.the_night_watch_painter,
                year = R.string.the_night_watch_year,
                nextClick = { currentPic++ },
                prevClick = { currentPic-- }
            )
        }
        8-> {
            PhotoAlbum(
                contentDescription = R.string.whistlers_mothers_description.toString(),
                drawableResourceId = R.drawable.whistlers_mother_high_res,
                title = R.string.whistlers_mothers_title,
                year = R.string.whistlers_mothers_year,
                author = R.string.whistlers_mothers_painter,
                nextClick = { currentPic++ },
                prevClick = { currentPic-- }
            )
        }
        9-> {
            PhotoAlbum(
                contentDescription = R.string.starry_night_description.toString(),
                drawableResourceId = R.drawable.starry_night,
                title = R.string.starry_night_title,
                year = R.string.starry_night_year,
                author = R.string.starry_night_painter,
                nextClick = { currentPic = 9},
                prevClick = { currentPic-- }
            )
        }
    }
}

@Composable
fun PhotoAlbum(
    drawableResourceId: Int,
    title: Int,
    author: Int,
    year: Int,
    contentDescription: String,
    nextClick: () -> Unit,
    prevClick: () -> Unit
){

    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Spacer(modifier= Modifier.height(40.dp))

        Image(
            painter = painterResource(drawableResourceId),
            contentDescription = contentDescription,modifier = Modifier
                .size(400.dp)
                .padding(20.dp)
        )
        Text(
                text = stringResource(title),
                textAlign= TextAlign.Center,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                modifier = Modifier.padding(20.dp))
        Text(
                text = (stringResource(author) + stringResource(year)),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(12.dp))
        Row(
            modifier = Modifier
        ){
            Button(
                onClick = {prevClick()},
                modifier = Modifier.padding(20.dp)) {
                Text(
                    text = stringResource(R.string.previous_photo))
            }
            Button(
                onClick =  {nextClick()},
                modifier = Modifier.padding(20.dp)) {
                Text(
                    text= stringResource(R.string.next_photo))
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