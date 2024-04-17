package br.org.sesisenai.ava.dto.implementation.usuario;

import lombok.Data;

import java.time.LocalDateTime;

@Data

public class UsuarioResponseDTO {

    private Long id;
    private String nome;
    private String email;
    private LocalDateTime dataCadastro;

}