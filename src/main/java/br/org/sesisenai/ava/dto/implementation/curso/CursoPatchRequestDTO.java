package br.org.sesisenai.ava.dto.implementation.curso;

import br.org.sesisenai.ava.dto.abstraction.AtualizacaoRequestConversorDTO;
import br.org.sesisenai.ava.entity.Curso;
import br.org.sesisenai.ava.entity.Instrutor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CursoPatchRequestDTO implements AtualizacaoRequestConversorDTO<Curso> {

    private Long instrutorId;

    @Override
    public Curso toEntity(Curso curso) {
        Instrutor instrutor = new Instrutor(this.instrutorId);
        curso.setInstrutor(instrutor);
        return curso;
    }
}
