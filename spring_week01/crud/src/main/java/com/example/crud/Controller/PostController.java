//package com.example.crud.Controller;
//
//import com.example.crud.Dto.MemberDto;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/v1/post-api") //공통주소
//public class PostController {
//
//    //http://localhost:8080/api/v1/post-api/member
//    //postman으로 json형식으로 body전송
//    @PostMapping("/member")
//    public String postMember(@RequestBody Map<String, Object> postdata) {
//        StringBuilder sb = new StringBuilder();
//
//        postdata.entrySet().forEach(map -> {
//            sb.append(map.getKey() + " : " + map.getValue() + "\n");
//        });
//        return sb.toString();
//    }
//
//    //http://localhost:8080/api/v1/post-api/member2
//    //postman으로 json형식으로 body전송
//    @PostMapping(value = "/member2")
//    public String postMember2(@RequestBody MemberDto memberDto) {
//        return memberDto.toString();
//    }
//}
