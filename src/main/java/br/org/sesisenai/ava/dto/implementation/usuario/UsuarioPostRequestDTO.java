package br.org.sesisenai.ava.dto.implementation.usuario;

import br.org.sesisenai.ava.dto.abstraction.CriacaoRequestConversorDTO;
import br.org.sesisenai.ava.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioPostRequestDTO implements CriacaoRequestConversorDTO<Usuario> {

    private String nome;
    private String email;
    private String senha;


    public Usuario toEntity() {
        Usuario usuario = new Usuario();
        usuario.setNome(this.nome);
        usuario.setEmail(this.email);
        usuario.setSenha(this.senha);
        usuario.setDataCadastro(LocalDateTime.now());
        return usuario;
    }

}