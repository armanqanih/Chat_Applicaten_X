package org.lotka.xenonx.presentation.ui.screens.frament

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.lotka.xenonx.R

@Composable
fun FloatingActionButton() {
    Box(
        modifier = Modifier
            .height(50.dp)
            .width(150.dp)
            .padding(5.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = Color.Green),
        contentAlignment = Alignment.Center
    ){

        Row (modifier = Modifier.fillMaxWidth()
        , horizontalArrangement = Arrangement.Center
            , verticalAlignment = Alignment.CenterVertically
        ){
            Icon(painter = painterResource(id = R.drawable.vector), contentDescription =
            null
            )
            Text(text = " Add Address")
        }

    }
}