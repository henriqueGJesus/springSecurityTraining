package br.org.sesisenai.ava.enumerators;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public enum Authorities implements GrantedAuthority {
    DELETE("DELETE"),
    POST("POST"),

    PUT("PUT"),

    GET("GET");

    private final String nome;

    @Override
    public String getAuthority() {
        return nome;
    }
}
