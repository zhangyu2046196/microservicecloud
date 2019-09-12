package com.youyuan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhangyu
 * @version 1.0
 * @description 部门消费者主程序
 * @date 2019/1/2 22:15
 *
 * @EnableEurekaClient 打开服务发现注册功能
 *
 * @EnableFeignClients 打开Feign负载均衡功能
 */
@EnableFeignClients(basePackages= {"com.youyuan.springcloud"})
@EnableEurekaClient
@SpringBootApplication
public class DeptConsumer81_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer81_App.class,args);
    }
}
