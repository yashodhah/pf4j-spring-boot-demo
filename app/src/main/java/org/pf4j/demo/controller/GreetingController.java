package org.pf4j.demo.controller;

import org.pf4j.demo.service.GreetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    GreetingsService greetingsService;

    @GetMapping("/greetings")
    public void greeting(){
        greetingsService.printGreetings();
    }
}
