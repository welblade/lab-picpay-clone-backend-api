package com.github.welblade.labpicpayclonebackendapi.data.service

import com.github.welblade.labpicpayclonebackendapi.core.exception.BusinessException
import com.github.welblade.labpicpayclonebackendapi.data.model.transacao.Transacao
import com.github.welblade.labpicpayclonebackendapi.data.model.usuario.Usuario
import com.github.welblade.labpicpayclonebackendapi.data.repository.usuario.UsuarioRepository
import org.springframework.scheduling.annotation.Async

class UsuarioServiceImpl(
    private val usuarioRepository: UsuarioRepository
) : UsuarioService {
    override fun findByLogin(login: String): Usuario {
        return usuarioRepository.findByLogin(login)
    }

    override fun validar(vararg usuarios: Usuario) {
        usuarios.forEach { usuario ->
            if (usuario == null) {
                throw BusinessException()
            }
        }
    }
    @Async("asyncExecutor")
    override fun atualizaSaldo(transacao: Transacao, isCartaoCredito: Boolean) {
        decrementaSaldo(transacao, isCartaoCredito)
        incrementaSaldo(transacao)
    }

    private fun incrementaSaldo(transacao: Transacao) {
        usuarioRepository.updateIncrementarSaldo(transacao.destino.login, transacao.valor)
    }

    private fun decrementaSaldo(transacao: Transacao, isCartaoCredito: Boolean) {
        if (!isCartaoCredito) {
            usuarioRepository.updateDecrementarSaldo(transacao.origem.login, transacao.valor)
        }
    }
}