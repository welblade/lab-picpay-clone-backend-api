package com.github.welblade.labpicpayclonebackendapi.data.repository.transacao;

import com.github.welblade.labpicpayclonebackendapi.data.model.transacao.Transacao
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface TransacaoRepository : JpaRepository<Transacao, Long> {
    fun findByOrigem_LoginOrDestino_Login(login: String, login1: String, paginacao: Pageable):Page<Transacao>

}