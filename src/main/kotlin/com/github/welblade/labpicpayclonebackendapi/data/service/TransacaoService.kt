package com.github.welblade.labpicpayclonebackendapi.data.service

import com.github.welblade.labpicpayclonebackendapi.data.dto.model.transacao.TransacaoDto

interface TransacaoService {
    fun processar(transacaoDto: TransacaoDto): TransacaoDto
}
