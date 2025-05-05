package com.Charity.study_smart.ui.theme.presentation.task

import com.Charity.study_smart.domain.model.Subject
import com.Charity.study_smart.ui.theme.util.Priority

data class TaskState(
    val title: String = "",
    val description: String = "",
    val dueDate: Long? = null,
    val isTaskComplete: Boolean = false,
    val priority: Priority = Priority.LOW,
    val relatedToSubject: String? = null,
    val subjects: List<Subject> = emptyList(),
    val subjectId: Int? = null,
    val currentTaskId: Int? = null
)