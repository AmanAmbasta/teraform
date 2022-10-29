package com.example.finalrun.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.finalrun.R
import com.example.finalrun.ui.theme.Blue500
import com.example.finalrun.ui.theme.Gray500

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun cut(
    itemList: List<String>, label: String, selectedOptionTextPlaceholder: String
): String {
    var list = listOf<String>("sa","ga",)
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(selectedOptionTextPlaceholder) }
    Box(modifier = Modifier.fillMaxWidth()) {
        ExposedDropdownMenuBox(
            modifier = Modifier.fillMaxWidth(),
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
        ) {
            OutlinedTextField(
                modifier = Modifier.menuAnchor().fillMaxWidth(),
                readOnly = true,
                value = selectedOptionText,
                onValueChange = {},
                label = { Text(label) },
                trailingIcon = {
                    Icon(
                        Icons.Filled.ArrowDropDown,
                        "contentDescription",
                        modifier = Modifier
                            .rotate(if (expanded) 180f else 0f)
                            .size(30.dp)
                            .clickable { expanded = !expanded },
                        tint = Blue500
                    )
                })

            ExposedDropdownMenu(
                modifier = Modifier.fillMaxWidth().border(width = 1.dp, color = Gray500),
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                itemList.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = { Text(selectionOption) },
                        leadingIcon = {
                            Image(
                                painter = painterResource(id = R.drawable.dropdown_icon_bag),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(18.dp)
                                    .weight(0.8f)
                            )
                        },
                        onClick = {
                            selectedOptionText = selectionOption
                            expanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                    )
                }
            }
        }
    }
    return selectedOptionText
}

