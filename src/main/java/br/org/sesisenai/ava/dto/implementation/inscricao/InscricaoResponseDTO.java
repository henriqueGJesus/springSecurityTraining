package br.org.sesisenai.ava.dto.implementation.inscricao;

import br.org.sesisenai.ava.dto.implementation.curso.CursoResponseDTO;
import br.org.sesisenai.ava.dto.implementation.usuario.UsuarioResponseDTO;
import br.org.sesisenai.ava.entity.Curso;
import br.org.sesisenai.ava.entity.InscricaoId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InscricaoResponseDTO {
    private InscricaoId id;
    private UsuarioResponseDTO usuario;
    private CursoResponseDTO curso;
    private LocalDateTime dataInscricao;
}
