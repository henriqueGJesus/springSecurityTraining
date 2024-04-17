package br.org.sesisenai.ava.dto.implementation.instrutor;

import br.org.sesisenai.ava.dto.implementation.curso.CursoResponseDTO;
import br.org.sesisenai.ava.dto.implementation.usuario.UsuarioResponseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data

public class InstrutorResponseDTO extends UsuarioResponseDTO {

    private String areaEspecializacao;

}
