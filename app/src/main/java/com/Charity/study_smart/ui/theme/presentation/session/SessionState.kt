package com.Charity.study_smart.ui.theme.presentation.session

import com.Charity.study_smart.domain.model.Session
import com.Charity.study_smart.domain.model.Subject


data class SessionState(
    val subjects: List<Subject> = emptyList(),
    val sessions: List<Session> = emptyList(),
    val relatedToSubject: String? = null,
    val subjectId: Int? = null,
    val session: Session? = null
)