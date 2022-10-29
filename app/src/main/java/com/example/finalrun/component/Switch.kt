package com.example.finalrun.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalrun.ui.theme.Blue400
import com.example.finalrun.ui.theme.Blue500
import com.example.finalrun.ui.theme.Red400


@Composable
fun cSwitch(initalButtonStable: Boolean,modifier: Modifier=Modifier): Boolean {
    var isTrue by remember {
        mutableStateOf(initalButtonStable)
    }
    Column(modifier = modifier) {
        val icon: (@Composable () -> Unit) = if (isTrue) {
            {
                Box(modifier = Modifier.run {
                    clip(CircleShape)
                }, Alignment.TopCenter) {
                    Text(
                        text = "Y",
                        color = Blue500,
                        fontSize = 10.sp,
                        modifier = Modifier
                            .background(Color.White)
                            .padding(horizontal = 5.dp, vertical = 1.dp)
                            .clip(CircleShape)
                    )
                }
            }
        } else {
            {
                Box(modifier = Modifier.run {
                    clip(CircleShape)
                }, Alignment.TopCenter) {
                    Text(
                        text = "NA",
                        color = Color.Red,
                        fontSize = 9.sp,
                        modifier = Modifier
                            .background(Color.White)
                            .padding(2.dp)
                            .clip(CircleShape)
                    )
                }
            }
        }
        Switch(
            checked = isTrue,
            onCheckedChange = { isTrue = it },
            thumbContent = icon,
            colors = SwitchDefaults.colors(
                uncheckedTrackColor = Red400,
                uncheckedBorderColor = Red400,
                checkedBorderColor = Blue400,
                checkedTrackColor = Blue400,
                uncheckedThumbColor = Color.White
            )
        )

    }
return isTrue
}

//@Preview
//@Composable
//fun CPRadioButton() {
//    cSwitch()
//}
