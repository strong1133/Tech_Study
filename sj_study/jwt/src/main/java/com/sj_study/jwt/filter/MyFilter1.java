package com.sj_study.jwt.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFilter1 implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;


        //토큰: cos
        if (req.getRequestURL().equals("/api/login")){
            System.out.println("포스트요청됨");
            String headerAuth = req.getHeader("Authorization");
            System.out.println(headerAuth);
            System.out.println("필터1");

            if(headerAuth.equals("cos")){
                chain.doFilter(req, res);
            }else {
                PrintWriter out = res.getWriter();
                out.println("인증안됨");
            }
        }


    }
}
