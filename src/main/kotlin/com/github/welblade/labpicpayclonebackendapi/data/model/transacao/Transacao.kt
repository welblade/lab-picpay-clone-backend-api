package com.github.welblade.labpicpayclonebackendapi.data.model.transacao

import com.github.welblade.labpicpayclonebackendapi.data.model.usuario.Usuario
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "transacoes")
class Transacao(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    val id: Long? = null,
    val codigo: String,
    @ManyToOne(cascade = [CascadeType.MERGE])
    @JoinColumn(name = "usuario_origem", nullable = false)
    val origem: Usuario,
    @ManyToOne(cascade = [CascadeType.MERGE])
    @JoinColumn(name = "usuario_deslino", nullable = false)
    val destino: Usuario,
    val dataHora: LocalDateTime,
    val valor: Double,
)
