package com.github.welblade.labpicpayclonebackendapi.data.repository.transacao;

import com.github.welblade.labpicpayclonebackendapi.data.model.transacao.Transacao
import org.springframework.data.jpa.repository.JpaRepository

interface TransacaoRepository : JpaRepository<Transacao, Long> {

}