package br.org.sesisenai.ava.dto.implementation.aula;

import br.org.sesisenai.ava.dto.implementation.curso.CursoResponseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class AulaResponseDTO extends AulaDTO{
    private Long id;
    private LocalDateTime dataPublicacao;
    private CursoResponseDTO curso;
}
