package io.spring.eureka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceHiController {
    @Value("${server.port}")
    private String  port;

    @GetMapping(value = "/home")
    public String home(@RequestParam(name = "name",defaultValue = "forezp") String name){
        return "hi " + name + " ,i am from port:" + port;
    }
}
