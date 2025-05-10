package com.Charity.study_smart.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.Charity.study_smart.domain.model.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Upsert
    suspend fun upsertTask(task: Task)

    @Query("DELETE FROM Task WHERE taskId = :taskId")
    suspend fun deleteTask(taskId: Int)

    @Query("DELETE FROM Task WHERE taskSubjectId = :subjectId")
    suspend fun deleteTasksBySubjectId(subjectId: Int)

    @Query("SELECT * FROM Task WHERE taskId = :taskId")
    suspend fun getTaskById(taskId: String): Task?

    @Query("SELECT * FROM Task WHERE taskSubjectId = :subjectId")
    fun getTasksForSubject(subjectId: String): Flow<List<Task>>

    @Query("SELECT * FROM Task")
    fun getAllTasks(): Flow<List<Task>>
}