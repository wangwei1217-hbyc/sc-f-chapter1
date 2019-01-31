package io.spring.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;


/**
 * 在微服务架构中，业务都会被拆分成一个独立的服务，服务与服务的通讯是基于http restful的。
 * Spring cloud有两种服务调用方式，一种是ribbon+restTemplate，另一种是feign。
 *
 * ribbon是一个负载均衡客户端，可以很好的控制htt和tcp的一些行为。
 */

/**
 * 在ribbon使用断路器:
 *  1)pox.xml文件中加入spring-cloud-starter-netflix-hystrix的起步依赖
 *  2)程序的启动类ServiceRibbonApplication 加@EnableHystrix注解开启Hystrix
 *  3)改造HelloService类，在hiService方法上加上@HystrixCommand注解。该注解对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法
 */

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrix
public class ServiceRibbonApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceRibbonApplication.class);
    }
}
