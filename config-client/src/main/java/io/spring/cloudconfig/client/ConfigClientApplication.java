package io.spring.cloudconfig.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *在ConfigClientController中获取String ${foo}失败的原因：
 * 如果你的config-server端口不是默认的8888，那么config-client的配置文件名称必须是bootstrap.properties而不能使用application.properties，
 * 否则client连接的端口还是8888，不是你自己配置的。
 * 如果config-server端口为默认：8888，那么config-client的配置文件名称可以为bootstrap.properties，也可以为application.properties
 */

@SpringBootApplication
public class ConfigClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class);
    }
}
