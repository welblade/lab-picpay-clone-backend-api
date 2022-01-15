package com.github.welblade.labpicpayclonebackendapi.data.repository.usuario;

import com.github.welblade.labpicpayclonebackendapi.data.model.usuario.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

interface UsuarioRepository : JpaRepository<Usuario, Long> {
    fun findByLogin(login: String): Usuario

    @Modifying
    @Query("UPDATE Usuario u SET u.saldo = u.saldo +?2 WHERE u.login = ?1")
    fun updateIncrementarSaldo(login: String, valor: Double)

    @Modifying
    @Query("UPDATE Usuario u SET u.saldo = u.saldo -?2 WHERE u.login = ?1")
    fun updateDecrementarSaldo(login: String, valor: Double)
}