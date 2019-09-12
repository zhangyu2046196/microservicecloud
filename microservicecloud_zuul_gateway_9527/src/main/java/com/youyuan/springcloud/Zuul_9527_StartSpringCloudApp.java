package com.youyuan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author zhangyu
 * @version 1.0
 * @description zuul主程序
 * @date 2019/1/7 11:52
 *
 * @EnableZuulProxy 开启zuul功能
 *
 */
@EnableZuulProxy
@SpringBootApplication
public class Zuul_9527_StartSpringCloudApp {

    public static void main(String[] args) {
        SpringApplication.run(Zuul_9527_StartSpringCloudApp.class,args);
    }

}



