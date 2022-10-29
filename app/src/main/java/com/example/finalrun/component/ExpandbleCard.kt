@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.example.finalrun.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalrun.ui.theme.Blue400
import com.example.finalrun.ui.theme.Gray500
import com.example.finalrun.ui.theme.Shapes

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpandableCard(
    title: String, paddingValues: Int = 10, composableElement: @Composable() () -> Unit
) {
    var expandedState by remember {
        mutableStateOf(false)
    }
    val rotationState by animateFloatAsState(if (expandedState) 180f else 0f)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    300, easing = LinearOutSlowInEasing
                )
            ),
        shape = Shapes.medium,
//        onClick = { expandedState = !expandedState }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = title,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.weight(6f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Gray500
                )
                IconButton(
                    onClick = {
                        expandedState = !expandedState
                    },
                    modifier = Modifier
                        .rotate(rotationState)
                        .alpha(ContentAlpha.medium)
                        .then(Modifier.weight(1f))
                ) {
                    Icon(
                        Icons.Default.ArrowDropDown, null, modifier = Modifier, tint = Blue400
                    )
                }
            }
            if (expandedState) {
                composableElement()
            }
        }
    }
}

