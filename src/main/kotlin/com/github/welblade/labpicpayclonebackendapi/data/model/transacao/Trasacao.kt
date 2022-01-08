package com.github.welblade.labpicpayclonebackendapi.data.model.transacao

import com.github.welblade.labpicpayclonebackendapi.data.model.usuario.Usuario
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "transacoes")
data class Trasacao(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val codigo: String,
    @ManyToOne(cascade = [CascadeType.MERGE])
    @JoinColumn(name = "usuario_origem", nullable = false)
    val origem: Usuario,
    @ManyToOne(cascade = [CascadeType.MERGE])
    @JoinColumn(name = "usuario_deslino", nullable = false)
    val destino: Usuario,
    val dataHora: LocalDateTime,
    val valor: Double,
) {
    constructor() : this(0, "", Usuario(), Usuario(), LocalDateTime.now(), 0.0) {

    }
}
