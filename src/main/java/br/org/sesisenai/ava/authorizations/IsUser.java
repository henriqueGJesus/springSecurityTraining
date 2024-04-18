package br.org.sesisenai.ava.authorizations;

import br.org.sesisenai.ava.entity.Usuario;
import br.org.sesisenai.ava.entity.UsuarioDetailsEntity;
import br.org.sesisenai.ava.enumerators.Authorities;
import br.org.sesisenai.ava.repository.UsuarioRepository;
import br.org.sesisenai.ava.utils.ContainsAuthorizationUtils;
import lombok.AllArgsConstructor;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
@Component
@AllArgsConstructor
public class IsUser implements AuthorizationManager<RequestAuthorizationContext> {
    private ContainsAuthorizationUtils utils;
    @Override
    public AuthorizationDecision check(Supplier<Authentication> supplier, RequestAuthorizationContext object) {
        Map<String, String> variables = object.getVariables();
        String request = object.getRequest().getMethod();
        Long userID = Long.parseLong(variables.get("id"));
       UsuarioDetailsEntity usuarioDetailsEntity = (UsuarioDetailsEntity) supplier.get().getPrincipal();
        return new AuthorizationDecision(
                Objects.equals(usuarioDetailsEntity.getUsuario().getId(), userID)
                        && utils.contemAutorizacao(request,usuarioDetailsEntity)
        );
    }

    @Override
    public void verify(Supplier<Authentication> authentication, RequestAuthorizationContext object) {
        AuthorizationManager.super.verify(authentication, object);
    }


}
