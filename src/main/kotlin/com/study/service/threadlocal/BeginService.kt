package com.study.service.threadlocal

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BeginService {

    @Inject
    lateinit var service: ThreadStateService

    fun start(correlationId: String?) {
        service.setCorrelationId(correlationId)
    }
}