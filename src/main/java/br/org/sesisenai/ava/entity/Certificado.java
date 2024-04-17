package br.org.sesisenai.ava.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Certificado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(name = "nome_curso")
    private String nomeCurso;

    @Column(name = "data_emissao")
    private LocalDateTime dataEmissao;

    // Getters e setters
}