package com.dumas.pedestal.framework.configcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 配置中心
 *
 * @author dumas
 * @date 2021/12/07 5:07 PM
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.dumas.pedestal"})
public class ConfigCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterApplication.class, args);
    }
}
