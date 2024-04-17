package br.org.sesisenai.ava.dto.implementation.inscricao;

import br.org.sesisenai.ava.dto.abstraction.CriacaoRequestConversorDTO;
import br.org.sesisenai.ava.entity.Curso;
import br.org.sesisenai.ava.entity.Inscricao;
import br.org.sesisenai.ava.entity.InscricaoId;
import br.org.sesisenai.ava.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InscricaoDeleteRequestDTO implements CriacaoRequestConversorDTO<InscricaoId> {

    private Long usuarioId;
    private Long cursoId;

    @Override
    public InscricaoId toEntity() {
        return new InscricaoId(usuarioId, cursoId);
    }
}
