package com.github.welblade.labpicpayclonebackendapi.data.model.cartaocredito

import com.github.welblade.labpicpayclonebackendapi.data.model.usuario.Usuario
import javax.persistence.*

@Entity(name = "cartoes_credito")
data class CartaoCredito(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val numero: String,
    @Enumerated(EnumType.STRING)
    val bandeira: BandeiraCartao,
    val email: String,
    val numeroToken: String,
    @ManyToOne(cascade = [CascadeType.MERGE])
    @JoinColumn(name = "usuario_id", nullable = false)
    val usuario: Usuario = Usuario(),
) {
    constructor() : this(0, "", BandeiraCartao.NULL, "", "")


}
