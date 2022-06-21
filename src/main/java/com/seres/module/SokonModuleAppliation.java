package com.seres.module;

import com.seres.module.annotation.EnableParamLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.seres.*.mapper")
@EnableFeignClients
@EnableCircuitBreaker
@EnableParamLog
@ComponentScan
public class SokonModuleAppliation {
    public static void main(String[] args) {
            SpringApplication.run(SokonModuleAppliation.class,args);
    }
}
