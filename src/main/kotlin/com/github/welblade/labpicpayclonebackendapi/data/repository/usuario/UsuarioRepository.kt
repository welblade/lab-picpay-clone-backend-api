package com.github.welblade.labpicpayclonebackendapi.data.repository.usuario;

import com.github.welblade.labpicpayclonebackendapi.data.model.usuario.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<Usuario, Long> {
}