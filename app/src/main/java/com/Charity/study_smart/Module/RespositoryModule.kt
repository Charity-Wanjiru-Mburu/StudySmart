package com.Charity.Study_smart.di

import com.Charity.study_smart.data.respiratory.SessionRepositoryImpl
import com.Charity.study_smart.data.respiratory.SubjectRepositoryImpl
import com.Charity.study_smart.data.respiratory.TaskRepositoryImpl
import com.Charity.study_smart.domain.repository.SessionRepository
import com.Charity.study_smart.domain.repository.SubjectRepository
import com.Charity.study_smart.domain.repository.TaskRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindSubjectRepository(
        impl: SubjectRepositoryImpl
    ): SubjectRepository

    @Singleton
    @Binds
    abstract fun bindTaskRepository(
        impl: TaskRepositoryImpl
    ): TaskRepository

    @Singleton
    @Binds
    abstract fun bindSessionRepository(
        impl: SessionRepositoryImpl
    ): SessionRepository
}