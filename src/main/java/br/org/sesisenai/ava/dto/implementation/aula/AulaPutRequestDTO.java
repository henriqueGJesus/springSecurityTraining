package br.org.sesisenai.ava.dto.implementation.aula;

import br.org.sesisenai.ava.dto.abstraction.AtualizacaoRequestConversorDTO;
import br.org.sesisenai.ava.entity.Aula;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class AulaPutRequestDTO extends AulaDTO implements AtualizacaoRequestConversorDTO<Aula> {

    @Override
    public Aula toEntity(Aula aula) {
        aula.setTitulo(this.getTitulo());
        aula.setConteudo(this.getConteudo());
        return aula;
    }
}
