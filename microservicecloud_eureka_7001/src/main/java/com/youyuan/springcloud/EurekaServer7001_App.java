package com.youyuan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zhangyu
 * @version 1.0
 * @description eureka服务注册发现的启动程序
 * @date 2019/1/3 13:46
 *
 * @EnableEurekaServer 开启eureka服务注册服务端,用于接收微服务的注册
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer7001_App {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7001_App.class,args);
    }
}
