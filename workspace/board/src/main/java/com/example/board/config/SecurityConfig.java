package com.example.board.config;

import com.example.board.service.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@Configuration
@EnableWebSecurity // 웹 보안 활성화, Spring Security
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                // cross-site request forgery
                .csrf(AbstractHttpConfigurer::disable)
                // 요청에 대한 인증 및 인가를 설정
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                )
                // 로그인을 OAuth2기반으로 구성!
                .oauth2Login(login -> login
                        .userInfoEndpoint(userInfo -> userInfo
                                .userService(customOAuth2UserService)
                        ).successHandler(authenticationSuccessHandler())
                )
                // 로그아웃
                .logout(logout -> logout
                                .logoutSuccessHandler((request, response, authentication) -> {
                                    //
//                            String clientId = request.getParameter("ClientId");
                                    String clientId = "97138660e8128c65e695d4edb0d77d18";
                                    String logoutRedirectUri = "http://localhost:8090";
                                    String logoutUri = "https://kauth.kakao.com/oauth/logout?client_id=" + clientId + "&logout_redirect_uri=" + logoutRedirectUri;
                                    response.sendRedirect(logoutUri);
                                })
                )
                .build();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return (request, response, auth) -> {
            response.sendRedirect("/");
        };
    }
}
