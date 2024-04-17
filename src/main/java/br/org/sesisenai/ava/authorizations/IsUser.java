package br.org.sesisenai.ava.authorizations;

import br.org.sesisenai.ava.entity.Usuario;
import br.org.sesisenai.ava.entity.UsuarioDetailsEntity;
import br.org.sesisenai.ava.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Supplier;
@Component
@AllArgsConstructor
public class IsUser implements AuthorizationManager<RequestAuthorizationContext> {

    @Override
    public AuthorizationDecision check(Supplier<Authentication> supplier, RequestAuthorizationContext object) {
        Map<String, String> variables = object.getVariables();
        Long userID = Long.parseLong(variables.get("id"));
        boolean decision = false;

       UsuarioDetailsEntity usuarioDetailsEntity = (UsuarioDetailsEntity) supplier.get().getPrincipal();
       if(usuarioDetailsEntity.getUsuario().getId() == userID){
           decision= true;
       }
        return new AuthorizationDecision(decision);
    }

    @Override
    public void verify(Supplier<Authentication> authentication, RequestAuthorizationContext object) {
        AuthorizationManager.super.verify(authentication, object);
    }
}
