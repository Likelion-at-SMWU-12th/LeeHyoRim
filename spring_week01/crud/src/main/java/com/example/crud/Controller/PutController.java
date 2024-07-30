package com.example.crud.Controller;

import com.example.crud.Dto.MemberDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

//Post와 동일한 방식
@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDto> postMemberDto3(@RequestBody MemberDto memberDto) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDto);
    }
    
}
