package br.org.sesisenai.ava.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InscricaoId implements Serializable {

    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "curso_id")
    private Long cursoId;
}
