package study.querydsl.Controller;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.querydsl.Dto.ValidRequestDto;
import study.querydsl.Dto.ValidationGroup1;
import study.querydsl.Dto.ValidationGroup2;

@RestController
@RequestMapping("/validation")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @PostMapping("/valid")
    public ResponseEntity<String> checkValidationByValid(@Valid @RequestBody ValidRequestDto validRequestDto){
        LOGGER.info(validRequestDto.toString());
        return ResponseEntity.ok().body(validRequestDto.toString());
    }

    @PostMapping("/valid/group1")
    public ResponseEntity<String> checkValidationByGroup1(@Validated(ValidationGroup1.class) @RequestBody ValidRequestDto validRequestDto){
        LOGGER.info(validRequestDto.toString());
        return ResponseEntity.ok().body(validRequestDto.toString());
    }

    @PostMapping("/valid/group2")
    public ResponseEntity<String> checkValidationByGroup2(@Validated(ValidationGroup2.class) @RequestBody ValidRequestDto validRequestDto){
        LOGGER.info(validRequestDto.toString());
        return ResponseEntity.ok().body(validRequestDto.toString());
    }

    @PostMapping("/valid/all-group")
    public ResponseEntity<String> checkValidationByAllGroup(@Validated({ValidationGroup1.class, ValidationGroup2.class}) @RequestBody ValidRequestDto validRequestDto){
        LOGGER.info(validRequestDto.toString());
        return ResponseEntity.ok().body(validRequestDto.toString());
    }
}
