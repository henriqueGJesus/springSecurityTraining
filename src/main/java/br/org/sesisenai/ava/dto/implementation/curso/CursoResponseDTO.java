package br.org.sesisenai.ava.dto.implementation.curso;

import br.org.sesisenai.ava.dto.implementation.instrutor.InstrutorResponseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class CursoResponseDTO extends CursoDTO {

    private Long id;
    private LocalDateTime dataCriacao;
    private InstrutorResponseDTO instrutor;

}