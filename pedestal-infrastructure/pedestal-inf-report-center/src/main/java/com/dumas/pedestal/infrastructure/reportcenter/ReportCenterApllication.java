package com.dumas.pedestal.infrastructure.reportcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 报表上报中心
 *
 * @author dumas
 * @date 2021/12/07 5:20 PM
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.dumas.pedestal"})
public class ReportCenterApllication {
    public static void main(String[] args) {
        SpringApplication.run(ReportCenterApllication.class);
    }
}
