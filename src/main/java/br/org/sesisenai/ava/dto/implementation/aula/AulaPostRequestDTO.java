package br.org.sesisenai.ava.dto.implementation.aula;

import br.org.sesisenai.ava.dto.abstraction.CriacaoRequestConversorDTO;
import br.org.sesisenai.ava.entity.Aula;
import br.org.sesisenai.ava.entity.Curso;
import lombok.*;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class AulaPostRequestDTO extends AulaDTO implements CriacaoRequestConversorDTO<Aula>{
    private Long cursoId;

    @Override
    public Aula toEntity() {
        Aula aula = new Aula();
        aula.setTitulo(this.getTitulo());
        aula.setConteudo(this.getConteudo());
        aula.setDataPublicacao(LocalDateTime.now());
        Curso curso = new Curso(this.cursoId);
        aula.setCurso(curso);
        return aula;
    }
}

