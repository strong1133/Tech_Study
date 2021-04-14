package com.sj_study.jwt.config;

import com.sj_study.jwt.config.jwt.JwtAuthenticationFilter;
import com.sj_study.jwt.config.jwt.JwtAuthorizationFilter;
import com.sj_study.jwt.repository.UserRepository;
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

    private final CorsConfig corsConfig; // CorsConfig에서 만든 Filter를 사용하기 위한 DI
    private final UserRepository userRepository;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    // http.addFilterBefore(new MyFilter1(), SecurityContextPersistenceFilter.class);
        http.headers().frameOptions().sameOrigin();
        http
                .addFilter(corsConfig.corsFilter()) // Cors필터링
                // @CrossOrigin => 인증이 필요 없는 경우 사용 // 인증이 필요한 경우에는 시큐리티에 등록 해줘야한다.
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
                .formLogin().disable() // 이녀석 때문에 별도의 로그인 시도를 캐치해줄 필터가 필요
                .httpBasic().disable()
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                // AuthenticationManager 이녀석은 로그인 매니져라고 생각하면 되며, JwtAuthenticationFilter 이녀석이 로그인 수행 필터이기 때문에
                // 매니저와 함께 해야 하므로 JwtAuthenticationFilter를 던져주면 된다.
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), userRepository))
                // JwtAuthorizationFilter 로그인 할 당시 클라이언트에게 준 토큰을 이용해 이후 요청이 들어오면 토큰이 유효한
                // 토큰인지를 검사해서 토큰에 해당하는 유저정보를 검색해준다. 유저 정보에 접근하기 위해 userRepository를 실어준다
                .authorizeRequests()
                // image 폴더를 login 없이 허용
                .antMatchers("/images/**").permitAll()
                // css 폴더를 login 없이 허용
                .antMatchers("/css/**").permitAll()
                // css 폴더를 login 없이 허용
                .antMatchers("/js/**").permitAll()
                .antMatchers("/api/**").permitAll()
                //H2 콘솔 허용
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated();

    }
}
