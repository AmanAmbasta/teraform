package com.example.finalrun

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.finalrun.component.ExpandableCard
import com.example.finalrun.ui.theme.Blue500

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShowCase()
        }
    }
}

@Composable
fun ShowCase() {
    Column (){
        HeaderSection()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 20.dp),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                ExpandableCard(title = "Work Summary ") {
                    WorkForm()
                }
                ExpandableCard(title = "Hot Work Permit Checklist") {
                    PermitChecklist()
                }
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 25.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                var autoSave by remember { mutableStateOf(true) }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .clickable { autoSave = !autoSave },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Checkbox(
                        checked = autoSave,
                        onCheckedChange = { autoSave = !autoSave },
                        colors = CheckboxDefaults.colors(checkedColor = Blue500)
                    )
                    Text(text = "Save it to auto-fill")
                }
                Button(
                    onClick = { },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Blue500, contentColor = Color.White
                    )
                ) {
                    Text(text = "Create", modifier = Modifier.padding(vertical = 5.dp))
                }
            }
        }
    }
}

