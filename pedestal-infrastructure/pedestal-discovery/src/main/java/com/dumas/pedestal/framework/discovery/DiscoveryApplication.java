package com.dumas.pedestal.framework.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 注册发现中心
 *
 * @author dumas
 * @date 2021/12/07 5:10 PM
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.dumas.pedestal"})
public class DiscoveryApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryApplication.class, args);
    }
}
