package io.spring.eureka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.logging.Level;

@RestController
public class ServiceHiController {
    private static final Logger log = LoggerFactory.getLogger(ServiceHiController.class);
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
        log.info("calling trace service-hi  ");
        return restTemplate.getForObject("http://localhost:8989/miya",String.class);
    }

    @GetMapping("/info")
    public String info(){
        log.info("calling trace service-hi ");

        return "i'm service-hi";

    }
}
