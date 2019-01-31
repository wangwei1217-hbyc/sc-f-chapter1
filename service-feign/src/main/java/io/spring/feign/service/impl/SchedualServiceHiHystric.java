package io.spring.feign.service.impl;

import io.spring.feign.service.SchedualServiceHi;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromServiceHi(@RequestParam(value = "name") String name) {
        return "sorry-"+name+",remote service fail";
    }
}
