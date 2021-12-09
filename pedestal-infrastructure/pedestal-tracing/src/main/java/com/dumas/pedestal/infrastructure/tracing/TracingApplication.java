package com.dumas.pedestal.infrastructure.tracing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 链路追踪中心
 *
 * @author dumas
 * @date 2021/12/07 5:21 PM
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.dumas.pedestal"})
public class TracingApplication {
    public static void main(String[] args) {
        SpringApplication.run(TracingApplication.class, args);
    }
}
