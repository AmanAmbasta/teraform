package com.example.finalrun

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalrun.ui.theme.Blue500

@Composable
fun HeaderSection() {
    Box(modifier = Modifier.fillMaxHeight(0.25f)) {
        Image(
            painterResource(id = R.drawable.mask_group),
            "This is the bg image",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.tint(Blue500, BlendMode.Multiply)
        )
        HeaderInfoAction()
    }
}


@Composable
fun HeaderInfoAction() {
    val buttonModifier = Modifier.run {
        background(Blue500)
        padding(15.dp)
        size(20.dp)
    }
    Row(
        modifier = Modifier.fillMaxSize()
            .padding(top = 30.dp, bottom = 0.dp, start = 15.dp, end = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(0.5f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            IconButton(onClick = {}, modifier = Modifier.clip(CircleShape).background(Blue500)) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "Left Arrow",
                    tint = Color.White,
                    modifier = buttonModifier
                )
            }

            Text(
                text = "Create Work Order",
                fontSize = 15.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
            )
        }
        IconButton(onClick = { }, modifier = Modifier.clip(CircleShape).background(Blue500)) {
            Icon(
                painterResource(id = R.drawable.clipboard_tickclipboard_tick),
                contentDescription = "Clipboard",
                tint = Color.White,
                modifier = buttonModifier
            )
        }
    }
}
