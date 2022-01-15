package com.github.welblade.labpicpayclonebackendapi.data.service

import com.github.welblade.labpicpayclonebackendapi.data.dto.model.transacao.TransacaoDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface TransacaoService {
    fun processar(transacaoDto: TransacaoDto): TransacaoDto
    fun listar(paginacao: Pageable, login: String): Page<TransacaoDto>
}
