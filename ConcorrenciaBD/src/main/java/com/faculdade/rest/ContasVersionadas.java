package com.faculdade.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contas-versionadas")
public class ContasVersionadas {
    
    @GetMapping("/test")
    public ResponseEntity<String> getMethodName() {
        return ResponseEntity.ok("endpoint funcionando com sucesso");
    }
}
