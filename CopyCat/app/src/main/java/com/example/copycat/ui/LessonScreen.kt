package com.example.copycat.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.example.copycat.data.Datasource
import com.example.copycat.model.Lesson

@Composable
fun LessonLayout(modifier: Modifier = Modifier, navController: NavController){
    Column {
        Button(
            onClick = {},
            shape = RectangleShape,
            border = BorderStroke(width = 1.dp, Color.Black),
            contentPadding = PaddingValues(vertical = 0.dp),
            colors = ButtonDefaults.buttonColors(Color(166, 140, 217)),

            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Text(
                "Slides",
                color = Color(76, 79, 102)
            )
        }
        Button(
            onClick = {},
            shape = RectangleShape,
            border = BorderStroke(width = 1.dp, Color.Black),
            contentPadding = PaddingValues(vertical = 0.dp),
            colors = ButtonDefaults.buttonColors(Color(166, 140, 217)),

            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Text(
                "Lab",
                color = Color(76, 79, 102)
            )
        }
        Button(
            onClick = { navController.navigate("learningModules") },
            shape = RectangleShape,
            border = BorderStroke(width = 1.dp, Color.Black),
            contentPadding = PaddingValues(vertical = 0.dp),
            colors = ButtonDefaults.buttonColors(Color(166, 140, 217)),

            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Text(
                "Back to Lessons",
                color = Color(76, 79, 102)
            )
        }
    }
}