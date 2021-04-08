package com.study.service

import io.micronaut.runtime.http.scope.RequestScope
import javax.annotation.PostConstruct

@RequestScope
class RequestScopeServiceImpl: RequestScopeService {

    private lateinit var value: String

    @PostConstruct
    fun init() {
        value = System.identityHashCode(this).toString()
    }

    override fun getValue(): String {
        return value
    }
}

interface RequestScopeService {
    fun getValue(): String
}