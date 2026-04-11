package com.github.irohasu2120.sample_bbs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
//    private final JwtAuthenticationFilter jwtFilter;
//
//    public SecurityConfig(JwtAuthenticationFilter jwtFilter) {
//        this.jwtFilter = jwtFilter;
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // RestfulAPIではCSRFは不要の為、無効にしておく
                .csrf(csrf -> csrf.disable())
                // RestfulAPIなので、セッション管理の方式をステートレスにする
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // 認可ルール
                .authorizeHttpRequests(auth -> auth
                        // サンプルは無認証でOK
                        .requestMatchers("/hello").permitAll()
                        // 上記以外は認証が必要
                        .anyRequest().authenticated()
                );
//                .addFilterBefore(new Jwt)
//                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
        return httpSecurity.build();
    }
}
