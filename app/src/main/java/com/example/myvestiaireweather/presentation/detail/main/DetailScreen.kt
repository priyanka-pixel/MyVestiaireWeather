package com.example.myvestiaireweather.presentation.detail.main

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailScreen(
    navController: NavController,
    viewModel: WeatherViewModel,
    index: Int
) {
    val state = viewModel.state.collectAsState().value.weathers[index]
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Paris") },
                backgroundColor = MaterialTheme.colors.background,
                contentColor = Color.Black,
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp, 24.dp)
                            .clickable {
                                navController.navigateUp()
                            },
                        tint = Color.Blue
                    )
                }
            )
        },
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clip(RoundedCornerShape(16.dp)),
            backgroundColor = MaterialTheme.colors.onSurface
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = state.temp.day.toString() + "°C",
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h3.copy(color = Color.White)
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = if (state.temp.day < 10) "Cold" else if (state.temp.day > 25) "Hot" else "Normal",
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.surface
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = state.weather[0].description,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.body1.copy(color = Color.White),
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Night: " + state.temp.night.toString() + "°C",
                    textAlign = TextAlign.Start,
                    fontFamily = FontFamily.Serif,
                    style = MaterialTheme.typography.body1.copy(color = Color.White),
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Feels like: " + state.feels_like.day.toString() + "°C",
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.body1.copy(color = Color.White),
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Max: " + state.temp.max.toString() + "°C",
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.body1.copy(color = Color.White),
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Min: " + state.temp.min.toString() + "°C",
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.body1.copy(color = Color.White),
                )
                Text(
                    text = "Pressure:" + state.pressure.toString(),
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.surface
                )
                AsyncImage(
                    model = "https://openweathermap.org/img/wn/" + state.weather[0].icon + "@2x.png",
                    contentDescription = "",
                    modifier = Modifier
//                                .align()
                        .size(300.dp)
                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Morning:" + state.temp.morn.toString(),
                    style = MaterialTheme.typography.subtitle1,
                    textAlign = TextAlign.End,
                    color = MaterialTheme.colors.surface
                )
                Text(
                    text = "Evening:" + state.temp.eve.toString(),
                    style = MaterialTheme.typography.subtitle1,
                    textAlign = TextAlign.Right,
                    color = MaterialTheme.colors.surface
                )

            }
        }
    }
}



