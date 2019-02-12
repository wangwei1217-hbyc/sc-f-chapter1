package io.spring.cloudconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 在分布式系统中，由于服务数量巨多，为了方便服务配置文件统一管理，实时更新，所以需要分布式配置中心组件。
 * 在Spring Cloud中，有分布式配置中心组件spring cloud config ，
 * 它支持配置服务放在配置服务的内存中（即本地），也支持放在远程Git仓库中。
 * 在spring cloud config 组件中，分两个角色，一是config server，二是config client。
 *
 * -----------------------------------------------------------------------
 *
 * http请求地址和资源文件映射如下:

 /{application}/{profile}[/{label}]
 /{application}-{profile}.yml
 /{label}/{application}-{profile}.yml
 /{application}-{profile}.properties
 /{label}/{application}-{profile}.properties
 ---------------------
示例：http://127.0.0.1:8888/config-client/dev/dev
 匹配：/{application}/{profile}[/{label}]  最后的dev(分支)在git上必须存在
 {
    name: "config-client",
    profiles: [
        "dev"
    ],
    label: "dev",
    version: "62a5e26a0f10ef579b96d75be36b37cc84385141",
    state: null,
    propertySources: [
        {
             name: "https://github.com/wangwei1217-hbyc/SpringcloudConfig/repo/config-client-dev.properties",
             source: {
                foo: "foo version 3"
            }
        }
    ]
 }

 */

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
@EnableEurekaClient
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class);
    }
}
