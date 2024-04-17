package br.org.sesisenai.ava.config;

import br.org.sesisenai.ava.authorizations.IsUser;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.AbstractConfiguredSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.SecurityContextRepository;

@AllArgsConstructor
@Configuration
public class SecurityConfig {

    private final SecurityContextRepository securityContextRepository;
    private  IsUser isUser;
    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.authorizeHttpRequests(authorizationRequestes -> authorizationRequestes
                .requestMatchers(HttpMethod.POST,"/login").permitAll()
                .requestMatchers(HttpMethod.GET,"/api/cursos").permitAll()
                .requestMatchers(HttpMethod.POST,"/api/usuarios").permitAll()
                .requestMatchers(HttpMethod.POST,"/api/instrutor").permitAll()
                .requestMatchers(HttpMethod.GET,"/api/usuarios/{id}").access(isUser)

                .anyRequest().authenticated());
        http.formLogin(Customizer.withDefaults());
        http.logout(Customizer.withDefaults());
        http.securityContext( context ->{
            context.securityContextRepository(securityContextRepository);
        });

        http.sessionManagement(config ->{
            config.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        });
        return http.build();
    }

}
