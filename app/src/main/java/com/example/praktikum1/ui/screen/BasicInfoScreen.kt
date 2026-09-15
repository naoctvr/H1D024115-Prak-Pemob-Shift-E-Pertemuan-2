package com.example.praktikum1.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.praktikum1.R


@Composable
fun BasicInfoScreen(
    onNavigateToContact: () -> Unit
) {

    Scaffold(

    ) { paddingValues ->

        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),

            horizontalAlignment = Alignment.CenterHorizontally

        ) {


            // Logo aplikasi
            Image(

                painter = painterResource(
                    id = R.mipmap.ic_launcher_foreground
                ),

                contentDescription = "Logo Aplikasi",

                modifier = Modifier.size(120.dp)

            )


            Spacer(
                modifier = Modifier.height(16.dp)
            )


            // Judul aplikasi
            Text(

                text = "Jualan",

                style = MaterialTheme.typography.headlineMedium

            )


            Spacer(
                modifier = Modifier.height(16.dp)
            )


            // Card Misi Kami
            Card(

                modifier = Modifier
                    .fillMaxWidth(),

                elevation = CardDefaults.cardElevation(
                    defaultElevation = 2.dp
                ),

                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.tertiary
                )

            ) {


                Column(

                    modifier = Modifier.padding(16.dp)

                ) {


                    Text(

                        text = "Misi Kami:",

                        style = MaterialTheme.typography.titleLarge,

                        color = Color.White

                    )


                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )


                    Text(

                        text = "Memajukan UMKM Lokal",

                        color = Color.White

                    )


                }

            }


            Spacer(

                modifier = Modifier.weight(1f)

            )


            // Tombol Hubungi Kami
            Button(

                onClick = onNavigateToContact,

                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)

            ) {


                Text(

                    text = "Hubungi Kami",

                    style = MaterialTheme.typography.labelLarge

                )


            }


            Spacer(

                modifier = Modifier.height(16.dp)

            )


        }

    }

}