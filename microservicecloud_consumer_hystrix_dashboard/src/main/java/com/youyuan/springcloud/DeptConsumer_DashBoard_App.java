package com.youyuan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author zhangyu
 * @version 1.0
 * @description hystrix dashboard主程序
 * @date 2019/1/7 10:13
 *
 * @EnableHystrixDashboard 打开hystrix服务监控功能
 *
 */
@EnableHystrixDashboard
@SpringBootApplication
public class DeptConsumer_DashBoard_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_DashBoard_App.class,args);
    }

}
