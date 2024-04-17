package br.org.sesisenai.ava.entity;

import br.org.sesisenai.ava.dto.abstraction.ResponseConversorDTO;
import br.org.sesisenai.ava.dto.implementation.aula.AulaResponseDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Aula implements ResponseConversorDTO<AulaResponseDTO> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String conteudo;
    private LocalDateTime dataPublicacao;

    @ManyToOne
    private Curso curso;

    @Override
    public AulaResponseDTO toDTO() {
        AulaResponseDTO aulaResponseDTO = new AulaResponseDTO();
        aulaResponseDTO.setId(this.id);
        aulaResponseDTO.setTitulo(this.titulo);
        aulaResponseDTO.setConteudo(this.conteudo);
        aulaResponseDTO.setDataPublicacao(this.dataPublicacao);
        aulaResponseDTO.setCurso(this.curso.toDTO());
        return aulaResponseDTO;
    }
}