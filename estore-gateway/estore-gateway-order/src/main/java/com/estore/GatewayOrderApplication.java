package com.estore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Janwes
 * @version 1.0
 * @package com.estore
 * @date 2021/7/27 17:36
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayOrderApplication.class, args);
    }
}
