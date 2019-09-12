package com.youyuan.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author zhangyu
 * @version 1.0
 * @description 自定义ribbon负载均衡算法
 * @date 2019/1/4 21:07
 *
 * 场景：要求每台机器被调用5次，然后在轮询调用下一台，每台机器被访问5次
 *
 *  参考github上随机负载均衡算法https://github.com/Netflix/ribbon/blob/master/ribbon-loadbalancer/src/main/java/com/netflix/loadbalancer/RandomRule.java
 *
 * 实现思路：
 * 定义一个变量totalCount存储调用次数，当被调用5次的时候重新赋值0，定义一个变量currentIndex存储服务列表下标，当下标
 * 值大于等于服务列表总数时重新赋值0来达到轮询调用的目的
 *
 */
public class RoundRobinRule_HXWL extends AbstractLoadBalancerRule {

    //存储一个机器被调用的次数
    private volatile Integer totalCount=0;
    //存储服务列表的下标
    private volatile Integer currentIndex=0;

    /**
     * Randomly choose from all living servers
     */
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

            if (totalCount<5){
                server=upList.get(currentIndex);
                totalCount++;
            }else{
                totalCount=0;
                currentIndex++;
                if (currentIndex>=serverCount){
                    currentIndex=0;
                }
                choose(lb,key);
            }

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
        // TODO Auto-generated method stub

    }
}