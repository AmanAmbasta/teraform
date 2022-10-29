package com.example.finalrun.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.finalrun.ui.theme.Gray500

@Composable
fun HeadingText(
    label: String
) {
    Text(text = label, fontSize = 15.sp, color = Gray500, fontWeight = FontWeight.Medium)
}


@Preview
@Composable
fun HeadingTextP(){
    HeadingText(label = "Select")
}