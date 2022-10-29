package com.example.finalrun

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.finalrun.component.cSwitch

@Composable
fun PermitChecklist() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 10.dp)
            .verticalScroll(
                rememberScrollState()
            ),
    ) {
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

@Composable
fun SwitchAndLabel(label: String, initialSwitchState: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(Dp.Hairline, Color.LightGray)
            .padding(start = 2.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(text = label, Modifier.weight(5f))
        cSwitch(initialSwitchState, Modifier.weight(1f))
    }

}

