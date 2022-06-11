package com.springboot.demo.config;

import com.springboot.demo.config.jwt.JwtAccessDeniedHandler;
import com.springboot.demo.config.jwt.JwtAuthenticationEntryPoint;
import com.springboot.demo.config.jwt.JwtSecurityConfig;
import com.springboot.demo.security.filter.JwtAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.filter.CorsFilter;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtAuthFilter jwtAuthFilter;
    private final TokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.cors()
                .and()
                .csrf()
                    .disable()
                .httpBasic()
                    .disable()
                .exceptionHandling()
                    .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                    .accessDeniedHandler(jwtAccessDeniedHandler)
                // 시큐리티는 기본적으로 세션을 사용
                // 여기서는 세션을 사용하지 않기 때문에 세션 설정을 Stateless 로 설정
                .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .apply(new JwtSecurityConfig(tokenProvider))
                // 로그인, 회원가입 API 는 토큰이 없는 상태에서 요청이 들어오기 때문에 permitAll 설정
                .and()
                    .authorizeRequests()

                    .antMatchers("/", "/auth/**").permitAll() // 이건 그냥 누구나 접근 가능

                    .antMatchers("/boards/**")
                    .access("hasRole('ROLE_USER') or hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
                    .antMatchers("/messages/**")
                    .access("hasRole('ROLE_USER') or hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
                    .antMatchers("/users/**")
                    .access("hasRole('ROLE_USER') or hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
                    .antMatchers("/comments/**")
                    .access("hasRole('ROLE_USER') or hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
                    .antMatchers("/test")
                    .access("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")
                    .antMatchers("/all").permitAll() // 이건 그냥 누구나 접근 가능

                    .anyRequest().authenticated() // 나머지는 전부 인증 필요
    //                .anyRequest().permitAll()   // 나머지는 모두 그냥 접근 가능

                    // JwtFilter 를 addFilterBefore 로 등록했던 JwtSecurityConfig 클래스를 적용
                ;
        //httpSecurity.addFilterAfter(new CorsFilter(), Filter.class);
        httpSecurity.addFilterAfter(jwtAuthFilter, CorsFilter.class);

    }
}
