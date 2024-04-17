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
public class InscricaoPostRequestDTO implements CriacaoRequestConversorDTO<Inscricao> {

    private Long usuarioId;
    private Long cursoId;

    @Override
    public Inscricao toEntity() {
        Inscricao inscricao = new Inscricao();
        inscricao.setCurso(new Curso(cursoId));
        inscricao.setUsuario(new Usuario(usuarioId));
        inscricao.setDataInscricao(LocalDateTime.now());
        return inscricao;
    }
}
