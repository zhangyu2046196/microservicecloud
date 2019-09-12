package com.youyuan.springcloud.controller;

import com.youyuan.bean.Dept;
import com.youyuan.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.ObjectInputStream;
import java.util.List;

/**
 * @author zhangyu
 * @version 1.0
 * @description 部门消费者控制类
 * @date 2019/1/2 22:03
 *
 * 使用Feign的负载均衡，是通过定义接口DeptClientService+在DeptClientServi使用注解@FeignClient 调用
 */
@RequestMapping("/consumer/dept")
@RestController
public class DeptConsumerController {

    /**
     * Feign接口
     */
    @Autowired
    private DeptClientService deptClientService;


    /**
     * 添加部门信息
     * @param dept 部门实体bean
     * @return 返回添加信息
     */
    @RequestMapping("/add")
    public boolean add(Dept dept){
        return deptClientService.add(dept);
    }

    /**
     * 根据主键查询
     * @param id 主键
     * @return 返回查询结果
     */
    @RequestMapping("/get/{id}")
    public Dept get(@PathVariable("id") Integer id){
        return deptClientService.get(id);
    }

    /**
     * 查询所有部门信息
     * @return 返回部门列表
     */
    @RequestMapping("/list")
    public List<Dept> list(){
        return deptClientService.list();
    }

    /**
     * 客户端访问eureka的注册服务信息
     * @return 返回查询的注册服务信息
     */
    @RequestMapping("/discovery")
    public Object discovery(){
        return deptClientService.discovery();
    }
}
