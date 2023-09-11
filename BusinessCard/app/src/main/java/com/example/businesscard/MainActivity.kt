package com.example.businesscard

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.LightGray
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp()
{
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var image = painterResource(id = R.drawable.android_logo)
        Section1(logo = image,
            name = stringResource(R.string.name_jiechang),
            title = stringResource(
                R.string.title_text
            ),
            modifier = Modifier.weight(1f)
        )
        Section2(
            phone = "123-223-222",
            socialMedia = "@JC",
            email = "jed@gmail.com",
            modifier = Modifier.weight(1f)
        )
    }
}


//the section for displaying logo, full name, title
@Composable
fun Section1(logo: Painter, name: String, title: String, modifier: Modifier = Modifier)
{
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = logo, contentDescription = null, modifier = Modifier
            .fillMaxSize(0.3f)
            .background(
                Color.Black
            ))
        Text(text = name)
        Text(text = title)
    }
}

//the section for displaying contact information
@Composable
fun Section2(phone: String, socialMedia: String, email: String, modifier: Modifier = Modifier)
{
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContactRow(icon = Icons.Rounded.Phone, text = phone )
        ContactRow(icon = Icons.Rounded.Share, text = socialMedia )
        ContactRow(icon = Icons.Rounded.Email, text = email )
    }
}

@Composable
fun ContactRow(icon: ImageVector, text: String)
{
    Row(
        horizontalArrangement = Arrangement.Center
    )
    {
        Icon(imageVector = icon, contentDescription = null)
        Text(text = text)
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}