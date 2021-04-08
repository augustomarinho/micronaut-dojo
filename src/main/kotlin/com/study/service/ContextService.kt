package com.study.service

import io.micronaut.context.annotation.Context
import java.util.*
import javax.annotation.PostConstruct
import javax.inject.Singleton

@Context
class ContextServiceImpl: ContextService {

    private lateinit var value: String

    @PostConstruct
    fun init() {
        value = UUID.randomUUID().toString()
    }

    override fun getValue(): String {
        return value
    }
}

interface ContextService {
    fun getValue(): String
}