package com.study.controller

import com.study.service.*
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import javax.inject.Inject


@Controller("/study2")
open class Bean2Controller @Inject constructor(
    private val singletonService: SingletonService,
    private val requestScopeService: RequestScopeService,
    private val prototypeService: PrototypeService,
    private val refreshableService: RefreshableService,
    private val contextService: ContextService
) {

    @Get
    @Produces(MediaType.TEXT_PLAIN)
    fun index(): String? {

        return "SingletonBean: ${singletonService.getValue()}\n\n" +
                "RequestScopeBean: ${requestScopeService.getValue()} \n\n" +
                "PrototypeBean: ${prototypeService.getValue()} \n\n" +
                "RefreshableBean: ${refreshableService.getValue()} \n\n" +
                "ContextBean: ${contextService.getValue()}\n\n"
    }
}