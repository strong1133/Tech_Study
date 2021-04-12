package com.sj_study.jwt.config;

import com.sj_study.jwt.config.jwt.JwtAuthenticationFilter;
import com.sj_study.jwt.filter.MyFilter1;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.web.filter.CorsFilter;

@Configuration // DI를 위한 IOC등록
@EnableWebSecurity // 시큐리티 적용 시작 -> 스프링 필터 체인에 등록된다.
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CorsFilter corsFilter; // CorsConfig에서 만든 Filter를 사용하기 위한 DI

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    // http.addFilterBefore(new MyFilter1(), SecurityContextPersistenceFilter.class);
        http.csrf().disable(); 
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //세션 사용x

                .and()
                .addFilter(corsFilter) // Cors필터링
                // @CrossOrigin => 인증이 필요 없는 경우 사용 // 인증이 필요한 경우에는 시큐s리티에 등록 해줘야한다.
                .formLogin().disable() // 이녀석 때문에 별도의 로그인 시도를 캐치해줄 필터가 필요
                .httpBasic().disable()
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                //AuthenticationManager 이녀석은 로그인 매니져라고 생각하면 되며, JwtAuthenticationFilter 이녀석이 로그인 수행 필터이기 때문에
                // 매니저와 함께 해야 하므로 JwtAuthenticationFilter를 던져주면 된다.
                .authorizeRequests()
                .anyRequest().permitAll();
    }
}
