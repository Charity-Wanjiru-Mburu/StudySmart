package com.Charity.study_smart.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.Charity.study_smart.ui.theme.presentation.Dashboard.DashboardScreen
import com.Charity.study_smart.ui.theme.presentation.Dashboard.DashboardScreenRoute
import com.Charity.study_smart.ui.theme.presentation.session.SessionScreen
import com.Charity.study_smart.ui.theme.presentation.session.SessionScreenRoute
import com.Charity.study_smart.ui.theme.presentation.subject.SubjectScreen
import com.Charity.study_smart.ui.theme.presentation.subject.SubjectScreenRoute

import com.Charity.study_smart.ui.theme.presentation.task.TaskScreenRoute


@Composable
fun AppNavHost(modifier: Modifier = Modifier,
               navController: NavController= rememberNavController(), startDestination: String=ROUTE_DASHBOARD) {
    NavHost(navController= navController , modifier = modifier, startDestination = startDestination){
        composable(ROUTE_DASHBOARD){
            DashboardScreenRoute(navController)
        }
        composable(ROUTE_SUBJECT){
            SubjectScreenRoute(navController)
        }
        composable(ROUTE_SESSION){
            SessionScreenRoute(navController)
        }
        composable(ROUTE_TASK){
            TaskScreenRoute(navController)
        }

    }

}


