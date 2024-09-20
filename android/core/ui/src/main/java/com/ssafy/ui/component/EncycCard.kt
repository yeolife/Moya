package com.ssafy.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ssafy.ui.R
import com.ssafy.ui.theme.DarkGrayColor
import com.ssafy.ui.theme.GrayColor
import com.ssafy.ui.theme.LightBackgroundColor
import com.ssafy.ui.theme.PrimaryColor
import com.ssafy.ui.theme.SurfaceColor

@Composable
fun PlantCard(plantName: String, isDiscovered: Boolean, onClick: () -> Unit = {}) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isDiscovered) SurfaceColor else GrayColor
        ),
        modifier = Modifier
            .padding(4.dp)
            .width(160.dp)
            .height(160.dp),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "도감 사진",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(LightBackgroundColor)
            )

            Text(
                text = plantName,
                fontSize = 14.sp,
                color = if (isDiscovered) PrimaryColor else DarkGrayColor,
                modifier = Modifier
                    .padding(8.dp),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlantCardPreview() {
    PlantCard(plantName = "능소화", isDiscovered = true) {

    }
}

@Preview(showBackground = true)
@Composable
fun PlantCardWithFalsePreview() {
    PlantCard(
        plantName = "능소화", isDiscovered = false
    ) {

    }
}