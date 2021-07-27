package com.estore;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Janwes
 * @version 1.0
 * @package com.estore
 * @date 2021/7/25 17:30
 * @description
 */
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.estore.*.mapper")
public class AdminApplication {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ConfigurableApplicationContext context = SpringApplication.run(AdminApplication.class, args);
        long time = (System.currentTimeMillis() - startTime) / 1000;

        String message = "启动完成-耗时：%d s，链接：http://%s:%s/doc.html";
        // 服务端口号
        String port = context.getEnvironment().getProperty("server.port");
        // 服务地址
        String address = context.getEnvironment().getProperty("spring.cloud.client.ip-address");

        log.info(String.format(message, time, address, port));
    }
}
