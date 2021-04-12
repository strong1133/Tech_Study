package com.sj_study.jwt.config.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sj_study.jwt.auth.PrincipalDetails;
import com.sj_study.jwt.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// 스프링 시큐리티에서 UsernamePasswordAuthenticationFilter가 있음
// login 요청해서 username, password 전송하면 (post)
// UsernamePasswordAuthenticationFilter 동작을 함.
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager; // 시큐리티에서 부를때 던져준 AuthenticationManager를 받아주는 역활

    //로그인 요청을 하면 로그인 시도를 위해서 실행되는 함수
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        System.out.println("JwtAuthenticationFilter: 로그인 시도중");

        //1. username, password를 받아서
        try {

            //  BufferedReader br = request.getReader();
            //  String input = null;
            //  while ((input = br.readLine()) != null){
            //  System.out.println(input);
            // }
            ObjectMapper om = new ObjectMapper();
            User user = om.readValue(request.getInputStream(), User.class);
            System.out.println(user);

            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

            // PricipalDetailsService의 loadUserByUsername() 함수가 실행됨
            Authentication authentication = authenticationManager.authenticate(authenticationToken);

            // authentication 객체가 세션영역에 저장됨 => 로그인이 되었다는 뜻
            PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
            System.out.println(principalDetails.getUser().getUsername());
            return authentication;
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("==================================================");
        //2. AuthenticationManager로 로그인 시도를 하면
        //   PrincipleDetailsService가 loadUserByUsername() 함수 실행

        //3. PrincipleDetails를 세션에 담고  -> 권한 관리 때문에 담는 것 (굳이 권한관리를 안할거면 없어도 됨)

        //4. JWT토큰을 만들어서 응답.
        return null;
    }
}
