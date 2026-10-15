package org.example.telegrambackend.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                // Tắt trang login
                .formLogin(form -> form.disable())

                // Tắt Basic Auth
                .httpBasic(basic -> basic.disable())

                .authorizeHttpRequests(auth -> auth
                        // Swagger
                        .requestMatchers(
                                "/api/auth/**",
                                "/swagger-ui.html",
                                "/swagger-ui/**",
                                "/v3/api-docs/**"
                        ).permitAll()

                        // Tạm thời cho toàn bộ API truy cập
                        .anyRequest().authenticated()

                )
                .oauth2ResourceServer(
                        oauth2 ->
                                oauth2.jwt(jwt -> {})
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtDecoder jwtDecoder(
            @Value("${jwt.secret}") String secret
    ){
        SecretKey secretKey = new SecretKeySpec(
                secret.getBytes(),
                "HmacSHA256"
        );
        return NimbusJwtDecoder
                .withSecretKey(secretKey)
                .build();
    }
}
