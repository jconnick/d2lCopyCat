package com.example.copycat.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
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
fun LessonButton(lesson: Lesson, modifier: Modifier = Modifier, navController: NavController){
    Button(
        onClick = { navController.navigate("lessonScreen")},
        shape = RectangleShape,
        border = BorderStroke(width = 1.dp, Color.Black ) ,
        contentPadding = PaddingValues(vertical = 0.dp),
        colors = ButtonDefaults.buttonColors(Color(166, 140, 217)),
        modifier = Modifier
            .fillMaxSize().height(100.dp)
    ) {
        Text(LocalContext.current.getString(lesson.stringResourceID),
            color = Color(76,79,102))
    }
}

@Composable
fun LessonList(lessonList: List<Lesson>, modifier: Modifier = Modifier, navController: NavController){
    LazyColumn (contentPadding = PaddingValues(vertical = 0.dp), modifier = modifier){
        items(lessonList) { lesson ->
            LessonButton(
                lesson = lesson,
                modifier = Modifier,
                navController = navController
            )
        }
    }
}

@Composable
fun LessonListTest(lessonList: List<Lesson>, modifier: Modifier = Modifier, navController: NavController){
    val scrollState = rememberScrollState()
    Column (Modifier.verticalScroll(scrollState)){
        lessonList.forEach { lesson ->
            LessonButton(
                lesson = lesson,
                modifier = Modifier,
                navController = navController
            )
        }
    }
}