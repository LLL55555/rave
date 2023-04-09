package com.cola.zhongdian.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerController {

    @Operation(hidden = true)
    @GetMapping("/swagger-ui/swagger-config")
    public ResponseEntity<Object> swaggerConfig() {
        return ResponseEntity.ok().body("");
    }
}
