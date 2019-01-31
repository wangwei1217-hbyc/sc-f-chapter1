package io.spring.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Feign是一个声明式的伪Http客户端，它使得写Http客户端变得更简单。
 * 使用Feign，只需要创建一个接口并注解。它具有可插拔的注解特性，可使用Feign 注解和JAX-RS注解。
 * Feign支持可插拔的编码器和解码器。Feign默认集成了Ribbon，并和Eureka结合，默认实现了负载均衡的效果。
 *
 *   Feign 采用的是基于接口的注解
     Feign 整合了ribbon，具有负载均衡的能力
     整合了Hystrix，具有熔断的能力

  pom文件引入Feign的起步依赖spring-cloud-starter-feign
 Eureka的起步依赖spring-cloud-starter-netflix-eureka-client、Web的起步依赖spring-boot-starter-web
 */


/**
 * 在微服务架构中，根据业务来拆分成一个个的服务，服务与服务之间可以相互调用（RPC），
 * 在Spring Cloud可以用RestTemplate+Ribbon和Feign来调用。为了保证其高可用，单个服务通常会集群部署。
 * 由于网络原因或者自身的原因，服务并不能保证100%可用，如果单个服务出现问题，调用这个服务就会出现线程阻塞，
 * 此时若有大量的请求涌入，Servlet容器的线程资源会被消耗完毕，导致服务瘫痪。服务与服务之间的依赖性，故障会传播，
 * 会对整个微服务系统造成灾难性的严重后果，这就是服务故障的“雪崩”效应。
 *
 *为了解决这个问题，业界提出了断路器模型。
 *
 * Feign是自带断路器的，在D版本的Spring Cloud之后，它没有默认打开。需要在配置文件中配置打开它，在配置文件加以下代码:
 *          feign.hystrix.enabled=true

 */

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
/**
 * 在程序的启动类ServiceFeignApplication ，加上@EnableFeignClients注解开启Feign的功能
 */
@EnableFeignClients
public class ServiceFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceFeignApplication.class);
    }
}
