package br.org.sesisenai.ava.entity;

import br.org.sesisenai.ava.dto.abstraction.ResponseConversorDTO;
import br.org.sesisenai.ava.dto.implementation.inscricao.InscricaoResponseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Inscricao implements ResponseConversorDTO<InscricaoResponseDTO> {

    @EmbeddedId
    private InscricaoId id;

    @ManyToOne
    @MapsId("usuarioId")
    private Usuario usuario;

    @ManyToOne
    @MapsId("cursoId")
    private Curso curso;

    @Column(name = "data_inscricao")
    private LocalDateTime dataInscricao;

    @Override
    public InscricaoResponseDTO toDTO() {
        InscricaoResponseDTO inscricaoDTO = new InscricaoResponseDTO();
        inscricaoDTO.setId(id);
        inscricaoDTO.setUsuario(usuario.toDTO());
        inscricaoDTO.setCurso(curso.toDTO());
        inscricaoDTO.setDataInscricao(dataInscricao);
        return inscricaoDTO;
    }
}
