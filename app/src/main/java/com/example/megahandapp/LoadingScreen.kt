package com.example.megahandapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Composable
fun LoadingScreen(
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFF46423E)
            ),
        contentAlignment = Alignment.BottomCenter
    ){
        Column(
            modifier = Modifier
                .padding(0.dp, 177.dp),
            verticalArrangement = Arrangement.spacedBy(169.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.logo_minimized),
                contentDescription = null
            )
            CircularProgressIndicator(
                modifier = Modifier
                    .size(28.dp),
                color = Color(0xFFE7D52F)
            )
        }
    }
}


@Preview
@Composable
fun LoadingScreenPreview(){
    LoadingScreen()
}