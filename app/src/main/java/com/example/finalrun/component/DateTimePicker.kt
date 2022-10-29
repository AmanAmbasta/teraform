package com.example.finalrun.component

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.finalrun.R
import com.example.finalrun.ui.theme.Blue500
import com.example.finalrun.ui.theme.Gray500
import java.util.*

@Composable
fun dateTimePicker(): String {
    val mContext = LocalContext.current
    val mCalendar = Calendar.getInstance()
    val mMonth = mCalendar.get(Calendar.MONTH)
    val mYear = mCalendar.get(Calendar.YEAR)
    val mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

    mCalendar.time = Date()

    val mDate = remember { mutableStateOf("") }
    val mDatePickerDialog = DatePickerDialog(
        mContext, { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            mDate.value = "$mDayOfMonth/${mMonth + 1}/$mYear"
        }, mYear, mMonth, mDay
    )

    Column(
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(onClick = { mDatePickerDialog.show() }) {
            OutlinedTextField(value = mDate.value,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { mDate.value = it },
                placeholder = { Text(text = "Select") },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.calendar_clock),
                        contentDescription = null
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Blue500,
                    unfocusedBorderColor = Gray500,
                )
            )
        }
    }
    return mDate.value
}

@Preview
@Composable
fun DateTimePickerPre() {

    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        dateTimePicker()

    }
}

