package com.github.wskel.userservice.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configurers.*
import org.springframework.security.config.http.SessionCreationPolicy.STATELESS
import org.springframework.security.web.SecurityFilterChain

@Configuration
class HttpSecurityConfiguration {

    @Bean
    @Throws(Exception::class)
    fun filterChain(httpSecurity: HttpSecurity): SecurityFilterChain =
        httpSecurity
            .cors(withDefaults())
            .csrf { it.disable() }
            .anonymous { it.disable() }
            .authorizeHttpRequests {
                it.requestMatchers("/api/hello")
                    .permitAll()
                    .anyRequest()
                    .authenticated()
            }
            .exceptionHandling {
                it.authenticationEntryPoint(null)
                    .accessDeniedHandler(null)
            }
            .sessionManagement { it.sessionCreationPolicy(STATELESS) }
            .build()

    // TODO: add filters
}