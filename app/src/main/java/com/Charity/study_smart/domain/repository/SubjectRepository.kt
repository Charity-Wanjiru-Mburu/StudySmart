package com.Charity.study_smart.domain.repository


import com.Charity.study_smart.domain.model.Subject
import kotlinx.coroutines.flow.Flow

interface SubjectRepository {

    suspend fun upsertSubject(subject: Subject)

    fun getTotalSubjectCount(): Flow<Int>

    fun getTotalGoalHours(): Flow<Float>

    suspend fun deleteSubject(subjectId: Int)

    suspend fun getSubjectById(subjectId: String): Subject?

    fun getAllSubjects(): Flow<List<Subject>>
}
