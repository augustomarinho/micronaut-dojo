package com.study.service.threadlocal

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FinishService {

    @Inject
    lateinit var service: ThreadStateService

    fun finish(): String? {
        return service.getCorrelationId()
    }
}