package com.github.welblade.labpicpayclonebackendapi.data.service

import com.github.welblade.labpicpayclonebackendapi.data.dto.model.cartaocredito.CartaoCreditoDto

interface CartaoCreditoService {
    fun salvar(cartaoCreditoDto: CartaoCreditoDto) : CartaoCreditoDto
}
