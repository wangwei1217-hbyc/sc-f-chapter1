package io.spring.eureka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ServiceMiYaController {
    private static final Logger log = LoggerFactory.getLogger(ServiceMiYaController.class);
    @Value("${server.port}")
    private String  port;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/home")
    public String home(@RequestParam(name = "name",defaultValue = "forezp") String name){
        return "hi " + name + " ,i am from port:" + port;
    }

    @GetMapping(value = "/hi")
    public String callHi(){
        log.info("hi is being called...");
        return "hi i'm miya!";
    }

    @GetMapping("/miya")
    public String info(){
        log.info("info is being called...");

        return restTemplate.getForObject("http://localhost:8763/info",String.class);

    }
}
