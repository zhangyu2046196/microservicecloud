package com.youyuan.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhangyu
 * @version 1.0
 * @description 主程序
 * @date 2019/1/2 19:02
 *
 * @MapperScan  标注mybatis扫描mapper的包
 * @EnableEurekaClient  开启Eureka的服务注册发现功能
 *
 */
@EnableEurekaClient
@MapperScan("com.youyuan.springcloud.dao")//扫描mapper路径
@SpringBootApplication
public class DeptProvider8002_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8002_App.class,args);
    }
}
