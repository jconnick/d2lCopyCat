package com.example.copycat.utils


import android.R.attr.label
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.ManageAccounts
import androidx.compose.material.icons.outlined.School
import androidx.compose.material.icons.outlined.WavingHand
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.copycat.model.BottomNavItem
import com.example.copycat.R

object Constants {
    val BottomNavItems = listOf(
        BottomNavItem(
            label = "Start Here",
            icon = Icons.Outlined.WavingHand,
            route = "startHere"
        ),
        BottomNavItem(
            label = "Learning Modules",
            icon = Icons.Outlined.School,
            route = "learningModules"
        ),
        BottomNavItem(
            label = "Account",
            icon = Icons.Outlined.ManageAccounts,
            route = "account"
        )
    )
}