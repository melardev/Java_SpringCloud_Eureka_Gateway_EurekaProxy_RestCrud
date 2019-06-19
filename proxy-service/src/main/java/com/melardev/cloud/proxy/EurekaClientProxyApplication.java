package com.melardev.cloud.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClientProxyApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientProxyApplication.class, args);
    }
}
