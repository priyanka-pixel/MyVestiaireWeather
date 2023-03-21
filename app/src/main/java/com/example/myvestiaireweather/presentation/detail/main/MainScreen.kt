package com.example.myvestiaireweather.presentation.detail.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.example.myvestiaireweather.util.Screen

@Composable
fun MainScreen(navController: NavController, viewModel: WeatherViewModel) {
    val state by viewModel.state.collectAsState()
    Surface(modifier = Modifier.fillMaxSize(), color = Color.Black) {
        Column(modifier = Modifier.fillMaxSize()) {
            if (state.weathers.isNotEmpty()) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                  text = "Paris",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.body1.copy(color = Color.White),
                    fontFamily = FontFamily.Serif

                )
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    backgroundColor = Color.Transparent
                )
                {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp)
                    ) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = state.weathers[0].temp.day.toString() + "°C",
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.h3.copy(color = Color.White)
                        )
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = state.weathers[0].weather[0].description,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.body1.copy(color = Color.White),
                        )
                        Spacer(modifier = Modifier.height(30.dp))
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Night: " + state.weathers[0].temp.night.toString() + "°C",
                            textAlign = TextAlign.Start,
                            fontFamily = FontFamily.Serif,
                            style = MaterialTheme.typography.body1.copy(color = Color.White),
                        )
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Feels like: " + state.weathers[0].feels_like.day.toString() + "°C",
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.body1.copy(color = Color.White),
                        )
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Max: " + state.weathers[0].temp.max.toString() + "°C",
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.body1.copy(color = Color.White),
                        )
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Min: " + state.weathers[0].temp.min.toString() + "°C",
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.body1.copy(color = Color.White),
                        )
                        AsyncImage(
                            model = "https://openweathermap.org/img/wn/" + state.weathers[0].weather[0].icon + "@2x.png",
                            contentDescription = "",
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .size(300.dp)
                        )
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Humidity Min: " + state.weathers[0].humidity.toString() + "°C",
                            textAlign = TextAlign.End,
                            style = MaterialTheme.typography.body1.copy(color = Color.White),
                        )
                    }
                }

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    contentPadding = PaddingValues(6.dp)
                ) {
                    itemsIndexed(state.weathers.drop(1)) { index, it ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(16.dp))
                                .clickable {
                                    navController.navigate(
                                        route = "${Screen.DetailScreen.route}/${index}"
                                    )
                                },

                            backgroundColor = Color.LightGray
                        ) {
                            Column {
                                AsyncImage(
                                    model = "https://openweathermap.org/img/wn/" + it.weather[0].icon + "@2x.png",
                                    contentDescription = "",
                                    modifier = Modifier
                                        .align(Alignment.CenterHorizontally)
                                        .size(100.dp)
                                )
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = "Max: " + it.temp.max.toString() + "°C",
                                    textAlign = TextAlign.Start,
                                    style = MaterialTheme.typography.body1,
                                )
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = "Min: " + it.temp.min.toString() + "°C",
                                    textAlign = TextAlign.Start,
                                    style = MaterialTheme.typography.body1,
                                )

                            }
                        }

                    }

                }
            }
        }
    }
}


