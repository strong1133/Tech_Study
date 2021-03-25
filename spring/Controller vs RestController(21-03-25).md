> # TIL - 2021-03-25

## 💡 @Controller 와 @RestController 차이

<hr/>

- Spirng 컨트롤러를 지정해주기 위한 어노테이션은 @Controller 와 @RestController가 있다.
- @Controller는 전통적인 Spring MVC의 컨트롤러이다.
- @RestController은 Restful 웹서비스의 컨트롤러이이다.

> 두개의 명확한 차이는 HTTP Response Body의 생성 방식이다.

<br/>
<br/>

## 💡 @Controller(Spring MVC Controller)

<hr/>

- 전통적인 Spring MVC의 컨트롤러 @Controller는 주로 View 를 반환하기 위해 사용한다.

- Data 를 반환해야 하는 경우 에는 @ResponseBody 어노테이션을 적용해서 Json 형태로 테이터를 반환!

```java
    @PostMapping(value = "/info")
    public @ResponseBody User info(@RequestBody User user){
        return userService.retrieveUserInfo(user);
    }
    @GetMapping(value = "/infoView")
    public String infoView(Model model, @RequestParam(value = "userName", required = true) String userName){
        User user = userService.retrieveUserInfo(userName);
        model.addAttribute("user", user);
        return "/user/userInfoView";
    }

// 이렇게 데이터를 반환하는 RestController와 View를 반환하는 Controller를 분리하여 작성하는 것이 좋음.
```

<br/>
<br/>

## 💡 @RestController(Spring Restful Controller)

<hr/>

- @RestController 는 spring MVC Controller에 @ResponseBody가 추가 된것.
- 당연하게도 JSON 형태로 객체 데이터 반환
