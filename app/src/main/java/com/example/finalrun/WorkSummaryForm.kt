@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.example.finalrun

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.finalrun.component.*
import com.example.finalrun.ui.theme.Blue500
import com.example.finalrun.ui.theme.Gray500


@Composable
fun SpacerSection() {
    Spacer(modifier = Modifier.height(25.dp))
}

@Composable
fun SpacerElement() {
    Spacer(modifier = Modifier.height(10.dp))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkForm() {
    val modifierMaxWidth = Modifier.fillMaxWidth()
    val textFieldColor = TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = Blue500, unfocusedBorderColor = Gray500
    )
    Column(
        modifier = modifierMaxWidth
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .verticalScroll(
                rememberScrollState()
            ),

        ) {
        //Project Details
        Column(modifier = modifierMaxWidth) {
            val projects = listOf("Project 1", "Project 2", "Project 3", "Project 4")
            var workOrderType by remember {
                mutableStateOf("")
            }
            HeadingText(label = "Project Details")
            dropbox(
                itemList = projects, label = "", selectedOptionTextPlaceholder = "Select Project"
            )
            SpacerElement()
            OutlinedTextField(
                modifier = modifierMaxWidth,
                value = workOrderType,
                onValueChange = { workOrderType = it },
                placeholder = {
                    Text(
                        text = "Work order type....", fontWeight = FontWeight.Light, color = Gray500
                    )
                },
                colors = textFieldColor
            )
        }
        SpacerSection()
        Column(modifier = Modifier) {
            HeadingText(label = "Start Date")
            SpacerElement()
            dateTimePicker()
            SpacerElement()
            HeadingText(label = "End Date")
            SpacerElement()
            dateTimePicker()
        }
        SpacerSection()
        Column(modifier = modifierMaxWidth) {
            HeadingText(label = "Location Details")
            val uniTypeItems = listOf("Cast House 1", "Cast House 2", "Cast House 3", "GAP 1")
            dropbox(
                itemList = uniTypeItems,
                label = "",
                selectedOptionTextPlaceholder = "Type Unit here"
            )
            val eqName = listOf(
                "Boiler 1", "Wire Rod Mill 1", "Ingot Casting Machine", "Rotating Kiln 2"
            )
            dropbox(
                itemList = eqName, label = "", selectedOptionTextPlaceholder = "Equipment Name"
            )

            val departmentItem = listOf(
                "Mechanical Maintenance", "Electrical Maintenance", "Process", "Civil"
            )
            dropbox(
                itemList = departmentItem, label = "", selectedOptionTextPlaceholder = "Department"
            )
        }

        SpacerSection()
        Column(modifierMaxWidth) {
            Row {
                HeadingText(label = "Operators")
                Text(text = "(Add more than one if needed)")
            }
            val personInvolved = listOf(
                "Ramesh Sahu",
                "Shrirang Patki",
                "Pushkar Singh",
                "Vamsi Sri Krishna",
            )
            dropBoxWithChip(
                itemList = personInvolved,
                label = "",
                selectedOptionTextPlaceholder = "Select person(s) involved"
            )
        }
        SpacerSection()
        SpacerSection()
        Column(modifierMaxWidth) {
            Row {
                HeadingText(label = "Tools Used")
                Text(text = "(Add more than one if needed)")
            }
            val toolUsedList = listOf(
                "Cutter",
                "Grinding M/C",
                "TIG Welding M/C",
                "MIG Welding M/C",
                "Grinding Machine",
            )
            dropBoxWithChip(
                itemList = toolUsedList,
                label = "",
                selectedOptionTextPlaceholder = "Select Tool(s) Used"
            )
        }
        SpacerSection()
        SpacerSection()
        Column(modifierMaxWidth) {
            Row {
                HeadingText(label = "Consumables")
                Text(text = "(Add more than one if needed)")
            }
            val consumablesList = listOf(
                "M8 Nut-Bolt",
                "Electrodes",
                "Cutting Disc",
                "Grease",
            )
            dropBoxWithChip(
                itemList = consumablesList,
                label = "",
                selectedOptionTextPlaceholder = "Select Spare(s) Consumed"
            )
        }
        SpacerSection()
        ExpandableCard(title = "Hot Work Permit Checklist") {

            Column(modifier = modifierMaxWidth) {}

            SwitchAndLabel(
                "Angle grinders provided with guards, Sparks Isolated with barriers ", true
            )
            SwitchAndLabel("Check the gauge, regulator & pipes of gas cutter", false)
            SwitchAndLabel(
                "Ensure Flash back arrester provided on both sides-Regulator & torch", true
            )
            SwitchAndLabel("Adequate means of ventilation for fumes available ", false)
            SwitchAndLabel("Welding cables in good condition ", true)
            SwitchAndLabel("Firefighting equipment provided & Firefighting team alerted", false)
            SwitchAndLabel(
                "Flammable & Combustibles removed & area around 35 feet of the work location is free\n" + "from flammables & combustibles & area cordoned off.",
                true
            )
            SwitchAndLabel(
                "Welding set: cables are in good condition & have proper lugs & welding set earthed &\n" + "supply drawn from ELCB/RCCB/GFCI protected source  ",
                true
            )
            SwitchAndLabel(
                "Fire watch assigned throughout the job & 30 mins post completion", false
            )
            SwitchAndLabel("Area barricated & Warning Signs posted", true)

        }

    }
}

