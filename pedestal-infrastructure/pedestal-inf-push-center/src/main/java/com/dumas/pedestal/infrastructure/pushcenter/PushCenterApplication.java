package com.dumas.pedestal.infrastructure.pushcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 推送中心
 *
 * @author dumas
 * @date 2021/12/07 5:18 PM
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.dumas.pedestal"})
public class PushCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(PushCenterApplication.class, args);
    }
}
