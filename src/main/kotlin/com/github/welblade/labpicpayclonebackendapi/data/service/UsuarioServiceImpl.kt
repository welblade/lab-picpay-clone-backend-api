package com.github.welblade.labpicpayclonebackendapi.data.service

import com.github.welblade.labpicpayclonebackendapi.core.exception.BusinessException
import com.github.welblade.labpicpayclonebackendapi.data.dto.mapper.UsuarioMapper
import com.github.welblade.labpicpayclonebackendapi.data.dto.model.usuario.UsuarioDto
import com.github.welblade.labpicpayclonebackendapi.data.model.transacao.Transacao
import com.github.welblade.labpicpayclonebackendapi.data.model.usuario.Usuario
import com.github.welblade.labpicpayclonebackendapi.data.repository.usuario.UsuarioRepository
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class UsuarioServiceImpl(
    private val usuarioRepository: UsuarioRepository,
    private val usuarioMapper: UsuarioMapper
) : UsuarioService {

    override fun findByLogin(login: String): Usuario {
        return usuarioRepository.findByLogin(login)
    }

    override fun findByLoginDto(login: String): UsuarioDto {
        return usuarioMapper.paraDto(findByLogin(login))
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

    override fun listarContatos(login: String): List<UsuarioDto> {
        val usuarios = usuarioRepository.findByLoginNot(login)
        return usuarioMapper.paraListaDto(usuarios)
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