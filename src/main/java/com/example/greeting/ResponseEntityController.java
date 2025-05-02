package com.example.greeting;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ResponseEntityController {

    // GET /success returns 200 OK with custom header
    @GetMapping("/success")
    public ResponseEntity<String> getSuccess() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Custom-Header", "OperationSuccessful");
        return ResponseEntity.ok()
                .headers(headers)
                .body("Request succeeded with a custom header.");
    }

    // GET /not-found returns 404 with error details
    @GetMapping("/not-found")
    public ResponseEntity<Map<String, String>> getNotFound() {
        Map<String, String> error = new HashMap<>();
        error.put("error", "Resource not found");
        error.put("status", "404");
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(error);
    }

    // POST /create returns 201 CREATED with location header
    @PostMapping("/create")
    public ResponseEntity<String> createSomething() {
        // Simulated resource creation with ID 101
        URI location = URI.create("/api/resource/101");
        return ResponseEntity.created(location)
                .body("Resource created successfully.");
    }
}

