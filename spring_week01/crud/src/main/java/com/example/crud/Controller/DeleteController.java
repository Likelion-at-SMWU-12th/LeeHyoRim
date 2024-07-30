package com.example.crud.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {

    @DeleteMapping(value = "/{variable}")
    public String deleteVariable(@PathVariable String variable) {
        return variable;
    }

    //http://localhost:8080/api/v1/delete-api/request1?email=naver
    @DeleteMapping(value = "/request1")
    public String getRequestParam1(@RequestParam String email) {
        return email;
    }
}
