package br.org.sesisenai.ava.utils;

import br.org.sesisenai.ava.entity.UsuarioDetailsEntity;
import br.org.sesisenai.ava.enumerators.Authorities;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ContainsAuthorizationUtils {

    public boolean contemAutorizacao(String request, UsuarioDetailsEntity usuarioDetailsEntity){
        Map<String, Boolean> allRequest = new HashMap<>();
        allRequest.put("GET", usuarioDetailsEntity.getAuthorities().contains(Authorities.GET));
        allRequest.put("PUT", usuarioDetailsEntity.getAuthorities().contains(Authorities.PUT));

        return allRequest.get(request);
    }
}
