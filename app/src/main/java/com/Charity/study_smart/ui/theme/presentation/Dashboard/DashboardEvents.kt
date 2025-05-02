package com.Charity.study_smart.ui.theme.presentation.Dashboard

import androidx.compose.ui.graphics.Color
import com.Charity.study_smart.domain.model.Session
import com.Charity.study_smart.domain.model.Task

sealed class DashboardEvent {
    data object SaveSubject : DashboardEvent()
    data object DeleteSession : DashboardEvent()
    data class OnDeleteSessionButtonClick(val session: Session): DashboardEvent()
    data class OnTaskIsCompleteChange(val task: Task): DashboardEvent()
    data class OnSubjectCardColorChange(val colors: List<Color>): DashboardEvent()
    data class OnSubjectNameChange(val name: String): DashboardEvent()
    data class OnGoalStudyHoursChange(val hours: String): DashboardEvent()
}