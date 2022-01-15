package com.github.welblade.labpicpayclonebackendapi.data.repository.cartaocredito;

import com.github.welblade.labpicpayclonebackendapi.data.model.cartaocredito.CartaoCredito
import org.springframework.data.jpa.repository.JpaRepository

interface CartaoCreditoRepository : JpaRepository<CartaoCredito, Long> {
}