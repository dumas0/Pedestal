package com.dumas.pedestal.ms.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author dumas
 * @date 2021/12/10 5:18 PM
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.dumas.pedestal"})
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class);
    }
}
