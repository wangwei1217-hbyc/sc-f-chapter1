package io.spring.eureka;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * ---- 断路器监控(Hystrix Dashboard)
 * 在微服务架构中为例保证程序的可用性，防止程序出错导致网络阻塞，出现了断路器模型。断路器的状况反应了一个程序的可用性和健壮性，它是一个重要指标。
 * Hystrix Dashboard是作为断路器状态的一个组件，提供了数据监控和友好的图形化界面。
 *
 * pom.xml文件中需要加入：spring-boot-starter-actuator、spring-cloud-starter-netflix-hystrix、spring-cloud-starter-netflix-hystrix-dashboard依赖
 *
 * 在程序的入口ServiceHiApplication类，加上@EnableHystrix注解开启断路器，这个是必须的，并且需要在程序中声明断路点HystrixCommand；
 * 加上@EnableHystrixDashboard注解，开启HystrixDashboard
 *
 * 依次开启eureka-server(集群，两个实例) 和service-hi.
 *
 * --打开http://localhost:8763/actuator/hystrix.stream，可以看到一些具体的数据
 * --打开localhost:8763/hystrix,在界面输入：http://localhost:8763/actuator/hystrix.stream
 *    在另一个窗口发一次请求： http://localhost:8763/home?name=forezp
 *    重新刷新hystrix.stream网页，你会看到良好的图形化界面
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableHystrixDashboard
public class ServiceHiApplication {
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceHiApplication.class);
    }
}
