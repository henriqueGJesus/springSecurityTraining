package br.org.sesisenai.ava.dto.implementation.usuario;

import br.org.sesisenai.ava.dto.abstraction.AtualizacaoRequestConversorDTO;
import br.org.sesisenai.ava.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioPutRequestDTO implements AtualizacaoRequestConversorDTO<Usuario> {

    private String nome;
    private String email;

    public Usuario toEntity(Usuario usuario) {
        usuario.setNome(this.nome);
        usuario.setEmail(this.email);
        return usuario;
    }
}