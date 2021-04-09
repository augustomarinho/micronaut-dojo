package com.study.service

import java.util.*
import javax.annotation.PostConstruct
import javax.inject.Singleton

@Singleton
class SingletonServiceImpl: SingletonService {

    private lateinit var value: String

    @PostConstruct
    fun init() {
        value = UUID.randomUUID().toString()
    }

    override fun getValue(): String {
        return value
    }
}

interface SingletonService {
    fun getValue(): String
}