package com.youyuan.springcloud.controller;

import com.youyuan.bean.Dept;
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
 * resttemplate使用方式：
 * 使用restTemplate访问restful接口非常的简单粗暴无脑。
(url, requestMap, ResponseBean.class)这三个参数分别代表
REST请求地址、请求参数、HTTP响应转换被转换成的对象类型
 *
 */
@RequestMapping("/consumer/dept")
@RestController
public class DeptConsumerController {

    //private static final String PROVIDER_URL_PREFIX="http://localhost:8001/dept/";//服务提供者地址前缀
    private static final String PROVIDER_URL_PREFIX="http://MICROSERVICECLOUD-DEPT";//服务提供者地址前缀

    /**
     * 操作restful的模板工具
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 添加部门信息
     * @param dept 部门实体bean
     * @return 返回添加信息
     */
    @RequestMapping("/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(PROVIDER_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    /**
     * 根据主键查询
     * @param id 主键
     * @return 返回查询结果
     */
    @RequestMapping("/get/{id}")
    public Dept get(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PROVIDER_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    /**
     * 查询所有部门信息
     * @return 返回部门列表
     */
    @RequestMapping("/list")
    public List<Dept> list(){
        return restTemplate.getForObject(PROVIDER_URL_PREFIX+"/dept/list",List.class);
    }

    /**
     * 客户端访问eureka的注册服务信息
     * @return 返回查询的注册服务信息
     */
    @RequestMapping("/discovery")
    public Object discovery(){
        return restTemplate.getForObject(PROVIDER_URL_PREFIX+"/dept/discovery",Object.class);
    }
}
