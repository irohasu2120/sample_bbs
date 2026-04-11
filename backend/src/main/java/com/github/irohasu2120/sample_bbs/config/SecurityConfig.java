package com.github.irohasu2120.sample_bbs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                // Basic認証を無効化
                .httpBasic(httpBasic -> httpBasic.disable())
                // 簡易ログインFormを無効化
                .formLogin(form -> form.disable())
                // RestfulAPIではCSRFは不要の為、無効にしておく
                .csrf(csrf -> csrf.disable())
                // RestfulAPIなので、セッション管理の方式をステートレスにする
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // JWT認証によるフィルター
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                // 認可ルール
                .authorizeHttpRequests(auth -> auth
                        // ログイン、サンプルは無認証でOK
                        .requestMatchers(HttpMethod.POST, "/login").permitAll()
                        .requestMatchers(HttpMethod.GET, "/hello").permitAll()
                        // 上記以外は認証が必要
                        .anyRequest().authenticated()
                );
        return httpSecurity.build();

    }

    /**
     * Spring Securityのデフォルトユーザー作成の無効化の為の処理
     * @return null
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> null; // 何も返さない（JWT 認証なので不要）
    }
}
