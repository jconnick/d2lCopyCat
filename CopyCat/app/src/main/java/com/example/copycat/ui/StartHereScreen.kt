package com.example.copycat.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.copycat.model.Lesson

@Composable
fun StartHereButton(label: String, modifier: Modifier = Modifier){
    Button(
        onClick = {},
        shape = RectangleShape,
        border = BorderStroke(width = 1.dp, Color.Black ) ,
        contentPadding = PaddingValues(vertical = 0.dp),
        colors = ButtonDefaults.buttonColors(Color(166, 140, 217)),

        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Text(label,
            color = Color(76,79,102))
    }
}

@Composable
fun StartHereList(modifier: Modifier = Modifier, navController: NavController, copyCatViewModel: CopyCatViewModel) {
    Column{
        StartHereButton("Welcome")
        StartHereButton("Syllabus")
        StartHereButton("Lab Report Instruction")
        StartHereButton("Project Instruction")
    }
}

@Preview
@Composable
private fun StartHerePreview(){
}


