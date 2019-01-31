package io.spring.cloudconfig.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {
    @Value("${foo}")
    private String foo;

    @GetMapping(value = "/hi")
    public String hi(){
        return foo;
    }
}
