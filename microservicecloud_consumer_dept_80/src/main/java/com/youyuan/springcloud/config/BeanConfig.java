package com.youyuan.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.omg.CORBA.IRObject;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhangyu
 * @version 1.0
 * @description 自定义配置类
 * @date 2019/1/2 22:19
 *
 * @LoadBalanced打开客户端负载均衡功能
 *
 */
@Configuration
public class BeanConfig {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 用随机负载均衡算法替换默认的轮询算法
     * @return
     */
    @Bean
    public IRule getRule(){
        //return new RandomRule();//指定随机负载均衡算法替换默认的轮询算法
        return new RetryRule();//用重试的负载均衡算法替换默认的轮询算法
    }
}
