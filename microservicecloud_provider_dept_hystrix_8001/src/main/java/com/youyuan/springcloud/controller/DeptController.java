package com.youyuan.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.youyuan.bean.Dept;
import com.youyuan.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhangyu
 * @version 1.0
 * @description 部门控制类
 * @date 2019/1/2 18:57
 */
@RequestMapping("/dept")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;


    @Autowired
    private DiscoveryClient discoveryClient;//用于服务发现

    /**
     * 保存
     * @param dept 部门实体bean
     * @return 返回保存结果
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public boolean add(Dept dept){
        return deptService.add(dept);
    }

    /**
     * 根据主键查询
     * @param id 主键
     * @return 返回部门实体bean
     */
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    //方法调用时报或出现异常后调用fallbackMethod指定的方法
    @HystrixCommand(fallbackMethod = "hystrixCommandMethod")
    public Dept get(@PathVariable("id") Integer id){
        Dept dept=deptService.get(id);
        if (dept==null){
            throw new RuntimeException("Id:"+id+"不存在......");
        }
        return dept;
    }

    /**
     * 服务异常后调用的方法
     * @param id
     * @return
     */
    private Dept hystrixCommandMethod(@PathVariable("id") Integer id){
        return new Dept().setDeptId(id).setDeptName("查询的结果不存在,进行服务熔断").setDbSource("要保存的数据库不存在");
    }

    /**
     * 查询所有部门信息
     * @return 返回部门列表
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Dept> list(){
        return deptService.list();
    }

    /**
     * 测试eureka服务发现，查询eureka注册服务信息
     * @return 返回注册服务信息
     */
    @RequestMapping(value = "/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        List<String> list = discoveryClient.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.discoveryClient;
    }
}
