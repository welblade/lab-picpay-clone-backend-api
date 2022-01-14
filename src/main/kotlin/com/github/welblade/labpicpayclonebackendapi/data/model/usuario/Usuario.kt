package com.github.welblade.labpicpayclonebackendapi.data.model.usuario

import com.github.welblade.labpicpayclonebackendapi.data.model.cartaocredito.CartaoCredito
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "usuarios")
data class Usuario(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val login: String,
    val senha: String,
    val email: String,
    val nomeCompleto: String,
    val cpf: String,
    val dataNascimento: LocalDateTime,
    val telefone: String,
    val saldo: Double,
    val ativo: Boolean,
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = [CascadeType.MERGE], orphanRemoval = true)
    val cartoesCredito: List<CartaoCredito> = listOf(),
) {


    constructor() : this(0, "", "", "", "", "", LocalDateTime.now(), "", 0.0, false)
}
