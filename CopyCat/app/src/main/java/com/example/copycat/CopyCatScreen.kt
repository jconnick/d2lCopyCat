package com.example.copycat

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.copycat.data.Datasource
import com.example.copycat.ui.AccountLayout
import com.example.copycat.ui.LessonListTest
import com.example.copycat.ui.StartHereList
import com.example.copycat.utils.Constants
import com.example.copycat.ui.CopyCatViewModel
import com.example.copycat.ui.CreateAccountLayout
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.copycat.ui.LessonList
import com.example.copycat.ui.LoginLayout
import com.example.copycat.ui.LessonLayout

enum class CopyCatScreen(@StringRes val title: Int){
    Login(title = R.string.login),
    CreateAccount(title = R.string.create_account),
    StartHere(title = R.string.start_here),
    LearningModules(title = R.string.learning_modules),
    Account(title = R.string.account)
}



@Composable
fun CopyCatApp() {
}

@Composable
fun NavHostContainer(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    padding: PaddingValues,
    copyCatViewModel: CopyCatViewModel
) {

    NavHost(
        navController = navController,

        // set the start destination as home
        startDestination = "login",

        // Set the padding provided by scaffold
        modifier = Modifier.padding(paddingValues = padding),

        builder = {

            composable("login"){
                LoginLayout(modifier, navController, copyCatViewModel)
            }

            composable("createAccount"){
                CreateAccountLayout(modifier, navController, copyCatViewModel)
            }


            // route : Home
            composable("startHere") {
                StartHereList(modifier, navController, copyCatViewModel)
            }

            // route : search
            composable("learningModules") {
                LessonList(lessonList = Datasource().loadLessons(), modifier, navController)
            }

            // route : profile
            composable("account") {
                AccountLayout(modifier, navController, copyCatViewModel)
            }

            composable ("lessonScreen"){
                LessonLayout(modifier, navController)
            }
        })
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {

    NavigationBar(

        // set background color
        containerColor = Color(196, 178, 230)) {

        // observe the backstack
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        // observe current route to change the icon
        // color,label color when navigated
        val currentRoute = navBackStackEntry?.destination?.route

        // Bottom nav items we declared

        Constants.BottomNavItems.forEach { navItem ->

            // Place the bottom nav items
            NavigationBarItem(

                // it currentRoute is equal then its selected route
                selected = currentRoute == navItem.route,

                // navigate on click
                onClick = {
                    navController.navigate(navItem.route)
                },

                // Icon of navItem
                icon = {
                    Icon(imageVector = navItem.icon, contentDescription = navItem.label)
                },

                // label
                label = {
                    Text(text = navItem.label)
                },
                alwaysShowLabel = false,

                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(76,79,102), // Icon color when selected
                    unselectedIconColor = Color(76,79,102), // Icon color when not selected
                    selectedTextColor = Color(76,79,102), // Label color when selected
                    indicatorColor = Color(166, 140, 217) // Highlight color for selected item
                )
            )
        }
    }
}