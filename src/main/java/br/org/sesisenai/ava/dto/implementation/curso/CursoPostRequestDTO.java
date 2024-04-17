package br.org.sesisenai.ava.dto.implementation.curso;

import br.org.sesisenai.ava.dto.abstraction.CriacaoRequestConversorDTO;
import br.org.sesisenai.ava.entity.Curso;
import br.org.sesisenai.ava.entity.Instrutor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class CursoPostRequestDTO extends CursoDTO implements CriacaoRequestConversorDTO<Curso> {

    private Long instrutorId;

    @Override
    public Curso toEntity() {
        Curso curso = new Curso();
        curso.setTitulo(this.getTitulo());
        curso.setDescricao(this.getDescricao());
        Instrutor instrutor = new Instrutor(this.instrutorId);
        curso.setInstrutor(instrutor);
        return curso;
    }
}
