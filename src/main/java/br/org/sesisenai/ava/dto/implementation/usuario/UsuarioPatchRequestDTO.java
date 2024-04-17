package br.org.sesisenai.ava.dto.implementation.usuario;

import br.org.sesisenai.ava.dto.abstraction.AtualizacaoRequestConversorDTO;
import br.org.sesisenai.ava.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioPatchRequestDTO implements AtualizacaoRequestConversorDTO<Usuario> {

    private String senha;

    public Usuario toEntity(Usuario usuario) {
        usuario.setSenha(this.senha);
        return usuario;
    }
}