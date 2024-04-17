package br.org.sesisenai.ava.entity;

import br.org.sesisenai.ava.dto.abstraction.ResponseConversorDTO;
import br.org.sesisenai.ava.dto.implementation.curso.CursoResponseDTO;
import br.org.sesisenai.ava.dto.implementation.instrutor.InstrutorResponseDTO;
import br.org.sesisenai.ava.dto.implementation.usuario.UsuarioResponseDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
public class Instrutor extends Usuario {

    private String areaEspecializacao;

    @OneToMany(mappedBy = "instrutor")
    private Set<Curso> cursos;

    public Instrutor(Long id) {
        super(id);
    }

    @Override
    public InstrutorResponseDTO toDTO() {
        InstrutorResponseDTO instrutorResponseDTO = new InstrutorResponseDTO();
        instrutorResponseDTO.setId(this.getId());
        instrutorResponseDTO.setNome(this.getNome());
        instrutorResponseDTO.setEmail(this.getEmail());
        instrutorResponseDTO.setAreaEspecializacao(this.areaEspecializacao);
        instrutorResponseDTO.setDataCadastro(this.getDataCadastro());
        return instrutorResponseDTO;
    }

}