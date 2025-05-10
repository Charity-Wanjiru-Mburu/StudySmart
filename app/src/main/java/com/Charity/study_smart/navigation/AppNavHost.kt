package com.Charity.study_smart.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

import com.Charity.study_smart.ui.theme.presentation.Dashboard.DashboardScreenRoute

import com.Charity.study_smart.ui.theme.presentation.session.SessionScreenRoute

import com.Charity.study_smart.ui.theme.presentation.subject.SubjectScreenRoute

import com.Charity.study_smart.ui.theme.presentation.task.TaskScreenRoute


import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.Charity.study_smart.ui.theme.presentation.session.StudySessionTimerService


@Composable
fun AppNavHost(modifier: Modifier=Modifier,navController:NavHostController= rememberNavController(),startDestination:String= ROUTE_DASHBOARD) {

    NavHost(navController = navController, modifier=modifier, startDestination = startDestination ){
        composable(ROUTE_DASHBOARD){
            DashboardScreenRoute(navController)
        }
        composable(
            route = "$ROUTE_SUBJECT/{subjectId}",
            arguments = listOf(navArgument("subjectId") { type = NavType.StringType })
        ) { backStackEntry ->
            val subjectId = backStackEntry.arguments?.getString("subjectId") ?: ""
            SubjectScreenRoute(navController, subjectId) // ✅ Pass subjectId
        }

        composable(ROUTE_SESSION) {
            val studySessionTimerService = StudySessionTimerService() // ✅ Create an instance
            SessionScreenRoute(navController, studySessionTimerService) // ✅ Pass the instance
        }
        composable(ROUTE_TASK) {
            TaskScreenRoute(navController)
        }

    }

}


