package io.spring.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;


/**
 * -------   断路器聚合监控(Hystrix Turbine)
 * 当我们有很多个服务的时候，这就需要聚合所以服务的Hystrix Dashboard的数据了。这就需要用到Spring Cloud的另一个组件了，即Hystrix Turbine
 *看单个的Hystrix Dashboard的数据并没有什么多大的价值，要想看这个系统的Hystrix Dashboard数据就需要用到Hystrix Turbine。
 * Hystrix Turbine将每个服务Hystrix Dashboard数据进行了整合。
 *
 *  --pom.xml添加相应的依赖
 *
 *  --在其入口类ServiceTurbineApplication加上注解@EnableTurbine，开启turbine，
 *    "@EnableTurbine"注解包含了"@EnableDiscoveryClient"注解，即开启了注册服务。
 *  --application.yml文件中加入相应配置：
 *
 *测试：依次启动两个Eureka-server实例、service-hi、service-miya、service-turbine
 *     依次请求：http://localhost:8763/home?name=wangwei-xiaoma  (service-hi)
 *             http://localhost:8989/home?name=lucy            (service-miya)
 *     打开:http://localhost:10000/hystrix,输入监控流http://localhost:10000/turbine.stream.
 *     可以看到这个页面聚合了2个service的hystrix dashbord数据。
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableTurbine
public class ServiceTurbineApplication {

    /**
     * http://127.0.0.1:10000/turbine.stream
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ServiceTurbineApplication.class,args);
    }
}
