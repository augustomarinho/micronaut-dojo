package com.study.service.app.dto

class PizzaRequest constructor(private val flavor: String) {

    fun getFlavor() = flavor
}