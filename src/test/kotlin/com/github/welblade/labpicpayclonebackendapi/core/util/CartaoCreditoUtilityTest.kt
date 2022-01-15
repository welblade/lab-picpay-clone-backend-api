package com.github.welblade.labpicpayclonebackendapi.core.util

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CartaoCreditoUtilityTest {

    @Test
    fun `dado o numero do cartao retorna o valor mascarado`(){
        val cardNumber = "0000111122223333"
        val transformedNumber = CartaoCreditoUtility.mask(cardNumber)
        assertEquals("0000XXXXXXXX3333", transformedNumber)
    }
}