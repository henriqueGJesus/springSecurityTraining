package br.org.sesisenai.ava.dto.implementation.instrutor;

import br.org.sesisenai.ava.dto.abstraction.CriacaoRequestConversorDTO;
import br.org.sesisenai.ava.entity.Instrutor;
import br.org.sesisenai.ava.entity.Usuario;
import br.org.sesisenai.ava.service.InstrutorService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstrutorPostRequestDTO implements CriacaoRequestConversorDTO<Instrutor> {

    private String nome;
    private String email;
    private String senha;
    private String areaEspecializacao;

    public Instrutor toEntity() {
        Instrutor instrutor = new Instrutor();
        instrutor.setNome(this.nome);
        instrutor.setEmail(this.email);
        instrutor.setSenha(this.senha);
        instrutor.setAreaEspecializacao(this.areaEspecializacao);
        instrutor.setDataCadastro(LocalDateTime.now());
        return instrutor;
    }
}