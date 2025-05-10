package com.Charity.study_smart.domain.repository

import com.Charity.study_smart.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    suspend fun upsertTask(task: Task)

    suspend fun deleteTask(taskId: Int)

    suspend fun getTaskById(taskId: String): Task?

    fun getUpcomingTasksForSubject(subjectId: String): Flow<List<Task>>

    fun getCompletedTasksForSubject(subjectId: String): Flow<List<Task>>

    fun getAllUpcomingTasks(): Flow<List<Task>>
}