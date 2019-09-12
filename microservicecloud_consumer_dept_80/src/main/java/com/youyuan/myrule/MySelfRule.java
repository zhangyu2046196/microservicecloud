package com.youyuan.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangyu
 * @version 1.0
 * @description 自定义Ribbon配置类
 * @date 2019/1/4 17:52
 *
 * 自定义的Ribbon配置类不能放在主程序所在的包及子包下，否则自定义的配置类就成了所有Ribbon客户端共享的配置了，达不到特殊化配置
 *
 */
@Configuration
public class MySelfRule {

    /**
     * 自定义负载均衡算法
     * @return
     */
    @Bean
    public IRule getRule(){
        //return new RandomRule();
        return new RoundRobinRule_HXWL();
    }
}
