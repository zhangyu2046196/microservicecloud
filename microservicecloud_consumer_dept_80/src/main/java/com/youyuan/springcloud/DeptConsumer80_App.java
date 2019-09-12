package com.youyuan.springcloud;

import com.youyuan.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author zhangyu
 * @version 1.0
 * @description 部门消费者主程序
 * @date 2019/1/2 22:15
 *
 * @EnableEurekaClient 打开服务发现注册功能
 * @RibbonClient 指定自定义Ribbon的配置类和作用在哪个微服务名称上
 *
 */
@EnableEurekaClient
@SpringBootApplication
@RibbonClient(name = "MICROSERVICECLOUD-DEPT",configuration = MySelfRule.class)
public class DeptConsumer80_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_App.class,args);
    }
}
