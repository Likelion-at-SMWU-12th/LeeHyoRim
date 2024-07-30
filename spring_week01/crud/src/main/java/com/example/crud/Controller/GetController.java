package com.example.crud.Controller;
import com.example.crud.Dto.MemberDto;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

//controller = url(브라우저)와 상호작용하며 객체를 전달

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    //http://localhost:8080/api/v1/get-api/hello
    //매개변수로 방식 기재
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String gethello() {
        return "Hello World";
    }

    //http://localhost:8080/api/v1/get-api/name
    //매개변수가 아닌 GET어노테이션을 사용
    @GetMapping(value = "/name")
    public String getName(){
        return "Flature";
    }

    //http://localhost:8080/api/v1/get-api/variable1/string
    //variable자리에 변수값을 넣어 요청 PathVariable어노테이션으로 명시
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable(@PathVariable String variable){
        return variable;
    }

    //http://localhost:8080/api/v1/get-api/request1?name=hyorim&email=naver&organization=lion
    //RequestParam어노테이션으로 쿼리로 변수를 보내는 ?param=param 형식 사용
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization){
        return name + " " + email + " " + organization;
    }

    //http://localhost:8080/api/v1/get-api/request2?name=hyorim&organization=lion
    //key가 어떤 값으로 들어올지 모를 때 Map객체로 받는 것이 효율적
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String,String> param){
        StringBuilder sb = new StringBuilder();
        
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    //http://localhost:8080/api/v1/get-api/request3?name=hyorim&email=naver&organization=lion
    //Dto객체를 사용해서(MemberDto클래스 정의) 전달
    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDto memberDto){
        return memberDto.toString();
    }
}
