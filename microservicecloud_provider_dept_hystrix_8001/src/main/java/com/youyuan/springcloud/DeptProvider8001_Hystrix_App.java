package com.youyuan.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhangyu
 * @version 1.0
 * @description 主程序
 * @date 2019/1/2 19:02
 *
 * @MapperScan  标注mybatis扫描mapper的包
 * @EnableEurekaClient  开启Eureka的服务注册发现功能
 * @EnableCircuitBreaker 打开对Hystrix熔断功能
 *
 */
@EnableEurekaClient
@EnableCircuitBreaker
@MapperScan("com.youyuan.springcloud.dao")//扫描mapper路径
@SpringBootApplication
public class DeptProvider8001_Hystrix_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8001_Hystrix_App.class,args);
    }
}
