package com.youyuan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author zhangyu
 * @version 1.0
 * @description springcloud config的主程序
 * @date 2019/1/7 17:16
 *
 * @EnableConfigServer 打开springclund config配置中心
 *
 */
@EnableConfigServer
@SpringBootApplication
public class Config_3344_StartSpringCloudApp {

    public static void main(String[] args) {
        SpringApplication.run(Config_3344_StartSpringCloudApp.class,args);
    }

}
