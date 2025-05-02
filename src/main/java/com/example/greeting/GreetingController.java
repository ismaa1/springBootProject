package com.example.greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class GreetingController {

    @GetMapping("/greets")
    public String  getGreeting() {
       return "welcome spring poot";

    }

}