package com.study.service.app.dto

import com.study.domain.Pizza

class PizzaResponse constructor(
    private val orderId: Int = 0,
    private val flavor: String = "NADA"
) {

    fun getOrderId() = orderId
    fun getFlavor() = flavor
    
    companion object {
        fun from(pizza: Pizza): PizzaResponse {
            return PizzaResponse(pizza.getOrderId(), pizza.getFlavor())
        }
    }
}