package com.study.service

import io.micronaut.runtime.context.scope.ThreadLocal
import java.util.*
import javax.annotation.PostConstruct
import javax.inject.Singleton

@ThreadLocal
class ThreadLocalServiceImpl: ThreadLocalService {

    private lateinit var value: String

    @PostConstruct
    fun init() {
        value = UUID.randomUUID().toString()
    }

    override fun getValue(): String {
        return value
    }
}

interface ThreadLocalService {
    fun getValue(): String
}