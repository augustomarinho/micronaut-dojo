package com.study.service.threadlocal

import io.micronaut.runtime.context.scope.ThreadLocal

@ThreadLocal
class ThreadStateService {

    private var correlationId: String? = null

    fun getCorrelationId(): String? {
        return correlationId
    }

    fun setCorrelationId(correlationId: String?) {
        this.correlationId = correlationId
    }
}