package br.org.sesisenai.ava.entity;

import br.org.sesisenai.ava.dto.implementation.curso.CursoResponseDTO;
import br.org.sesisenai.ava.dto.abstraction.ResponseConversorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso implements ResponseConversorDTO<CursoResponseDTO> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private LocalDateTime dataCriacao;

    @OneToMany(mappedBy = "curso")
    private Set<Aula> aulas;

    @ManyToOne
    private Instrutor instrutor;

    @OneToMany(mappedBy = "curso")
    private Set<Inscricao> inscricoes;

    public Curso(Long id) {
        this.id = id;
    }

    @Override
    public CursoResponseDTO toDTO() {
        CursoResponseDTO cursoResponseDTO = new CursoResponseDTO();
        cursoResponseDTO.setId(this.id);
        cursoResponseDTO.setTitulo(this.titulo);
        cursoResponseDTO.setDescricao(this.descricao);
        cursoResponseDTO.setDataCriacao(this.dataCriacao);
        cursoResponseDTO.setInstrutor(this.instrutor.toDTO());
        return cursoResponseDTO;
    }
}