package br.org.sesisenai.ava.dto.implementation.instrutor;

import br.org.sesisenai.ava.dto.abstraction.AtualizacaoRequestConversorDTO;
import br.org.sesisenai.ava.dto.abstraction.CriacaoRequestConversorDTO;
import br.org.sesisenai.ava.entity.Instrutor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstrutorPatchRequestDTO implements AtualizacaoRequestConversorDTO<Instrutor> {

    private String areaEspecializacao;

    public Instrutor toEntity(Instrutor instrutor) {
        instrutor.setAreaEspecializacao(this.areaEspecializacao);
        return instrutor;
    }
}