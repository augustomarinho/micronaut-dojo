package com.study.service.threadlocal

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BeginServiceImpl : BeginService {

    @Inject
    lateinit var service: ThreadStateService

    override fun start(correlationId: String?) {
        service.setCorrelationId(correlationId)
    }
}

interface BeginService {
    fun start(correlationId: String?)
}