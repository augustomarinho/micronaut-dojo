package com.study.service.threadlocal

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FinishServiceImpl : FinishService {

    @Inject
    lateinit var service: ThreadStateService

    override fun finish(): String? {
        return service.getCorrelationId()
    }
}

interface FinishService {
    fun finish(): String?
}
