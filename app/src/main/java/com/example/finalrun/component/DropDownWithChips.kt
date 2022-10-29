package com.example.finalrun.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.finalrun.ui.theme.Gray500

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun dropBoxWithChip(
    itemList: List<String>, label: String, selectedOptionTextPlaceholder: String
): List<String> {
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(selectedOptionTextPlaceholder) }
    var selectedOptions by remember { mutableStateOf(listOf<String>()) }
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(Modifier.fillMaxWidth()) {
            selectedOptions.forEachIndexed { index, element ->
                InputChip(selected = false,
                    onClick = {
                        selectedOptions =
                            (selectedOptions.toMutableList().filterIndexed { i, s -> i != index })
                    },
                    label = { Text(text = element) },
                    trailingIcon = { Icon(Icons.Default.Add, "", modifier = Modifier.rotate(45f)) },
                    colors = InputChipDefaults.inputChipColors(containerColor = Gray500),
                    border = InputChipDefaults.inputChipBorder(
                        borderWidth = Dp.Hairline,
                        borderColor = Color.Transparent,
                    )
                )
            }
        }
        ExposedDropdownMenuBox(
            modifier = Modifier.fillMaxWidth(),
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
        ) {
            OutlinedTextField(modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(),
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
                        tint = Color.Blue
                    )
                })

            ExposedDropdownMenu(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(width = 1.dp, color = Color.LightGray),
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                itemList.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = { Text(selectionOption) },
                        onClick = {
                            selectedOptionText = selectionOption
                            expanded = false
                            selectedOptions = selectedOptions + selectionOption
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                    )
                }
            }
        }
    }
    return selectedOptions
}

