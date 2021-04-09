package com.study.domain

import com.study.service.app.dto.PizzaRequest

data class Pizza constructor(
    private val orderId: Int = 0,
    private val flavor: String = "NADA"
) {

    fun getOrderId() = orderId
    fun getFlavor() = flavor
}