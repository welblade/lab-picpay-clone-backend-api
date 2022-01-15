package com.github.welblade.labpicpayclonebackendapi.data.model.cartaocredito

import com.github.welblade.labpicpayclonebackendapi.data.model.usuario.Usuario
import org.hibernate.Hibernate
import javax.persistence.*

@Entity(name = "cartoes_credito")
class CartaoCredito(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    val id: Long? = null,
    val numero: String,
    @Enumerated(EnumType.STRING)
    val bandeira: BandeiraCartao,
    val email: String,
    val numeroToken: String,
    @ManyToOne(cascade = [CascadeType.MERGE])
    @JoinColumn(name = "usuario_id", nullable = false)
    val usuario: Usuario,
)
