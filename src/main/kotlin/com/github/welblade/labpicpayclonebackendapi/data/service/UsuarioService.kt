package com.github.welblade.labpicpayclonebackendapi.data.service

import com.github.welblade.labpicpayclonebackendapi.data.model.transacao.Transacao
import com.github.welblade.labpicpayclonebackendapi.data.model.usuario.Usuario

interface UsuarioService {
    fun findByLogin(login: String): Usuario
    fun validar(vararg usuarios: Usuario)
    fun atualizaSaldo(transacao: Transacao, isCartaoCredito: Boolean)
}
