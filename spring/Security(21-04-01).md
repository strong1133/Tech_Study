> # TIL - 2021-03-31

## 💡 웹의 인증, 인가

<hr/>

> 인증 (Authentication): 사용자의 신원 확인

- ex) 회사 출입시 출입증 인식 후 입장

> 인가 (Authorization): 사용자의 권환 학왼

- ex) 방문자 -> 로비만 가능 || 직원 -> 사무실 접근 || 관리자 -> 서버실, 중앙공급실 접근

> 웹에서의 인증, 인가

- 인증: 로그인을 통해 본인임을 확인 -> Id,pw 이용
- 인가: 역활에 따른 권한 관리 -> 네이커 카페 느낌

</br></br>

## 💡 Spring Security

<hr/>

<div style="text-align:center"><img src="https://media.vlpt.us/post-images/hellas4/4c247d20-01f0-11ea-8ec4-9928fd13b4bf/logo.png" width="70%%"></img></div>

- Spring Security는 스프링 서버에 필요한 인증, 인가를 위해 많은 기능을 제공해주는 프레임워크이다!
- Spring Security에서는 주로 서블릿필터와 이들로 구성된 필터체인으로의 위임 모델을 사용

> 기본용어

        - 접근주체(Principal): 보호된 리소스에 접근하는 대상
        - 인증(Authentication): 보호된 리소소에 접근한 대상에 대해 누구인지,
          애플리케이션의 작업을 수행해도 되는 주체인지 확인하는 과정
        - 인가(Authorize): 해당 리소스에 대한 접근권한을 가지고 있는지 확인하는 과정
        - 권한: 어떠한 리소스에 대한 접근 제한

</br>

> Spring Security의 특징과 구조

- 보안 관련 체계적으로 많은 옵션을 제공하여 사용하기 편리
- Filter기반으로 동작하여 MVC와 분리하여 관리 및 동작
- 어노테이션을 통한 간단 설정
- 기본적으로 세션&쿠키 방식

<div style="text-align:center"><img src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FRdJGx%2FbtqD9Ouzlub%2F5At2yq9zCxACpguIwWKHE1%2Fimg.png" width="100%"></img></div>

- 인증관리자와 접근 결정 관리를 통해 사용자의 리소스 접근을 관리

</br></br>

## 💡 Spring Security의 전체적인 흐름

<hr/>

1. 사용자가 form을 통해 로그인 정보가 담긴 Request를 보냄.

2. AuthenticationFilter가 HttpServletRequest에서 사용자가 보낸 id, pw를 인터셉트한다.

3. 간단한 유효성을 검사한후 진짜 인증을 담당하는 AuthenticationManager에게 넘겨준다.

4. 넘겨 줄때 UsernamePasswordAuthenticationToken라는 인증용 객체로 만들어 넘겨준다.

5. 인증 절차가 시작되면 AuthenticationProvider 인터페이스가 실행.

   - AuthenticationProvider: 실제 인증이 일어나며, 성공하면 Authentication.isAuthenticated = true

6. DB에 있는 user정보와 대조

7. 인증이 완료되면 Authentication 객체를 SecurityContextHolder 담아 AuthenticationSuccessHandle를 실행

8. 오류시 AuthenticationFailureHandler 실행

</br>

        최종적으로 SecurityContextHolder는 세션 영역에 있는 SecurityContext에 Authentication 객체를 저장!
        -> 세션에 쿠키를 저장한다는것은 전통적인 세션-쿠키 기반의 인증방식을 의미!
