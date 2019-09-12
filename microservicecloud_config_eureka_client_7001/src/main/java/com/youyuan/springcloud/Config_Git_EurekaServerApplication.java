package com.youyuan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zhangyu
 * @version 1.0
 * @description eureka配置信息从springcloud config读取 主程序
 * @date 2019/1/7 19:57
 *
 * @EnableEurekaServer 开启服务注册功能
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class Config_Git_EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Config_Git_EurekaServerApplication.class,args);
    }

}
