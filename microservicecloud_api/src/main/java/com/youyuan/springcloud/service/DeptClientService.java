package com.youyuan.springcloud.service;

import com.youyuan.bean.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author zhangyu
 * @version 1.0
 * @description Feign负载均衡接口
 * @date 2019/1/4 22:25
 *
 * @FeignClient指定要访问微服务名称
 *
 */
@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory = DeptClientFallbackFactory.class)
public interface DeptClientService {
    /**
     * 添加部门信息
     * @param dept 部门实体bean
     * @return 返回添加信息
     */
    @RequestMapping(value = "/dept/add",method = RequestMethod.POST)
    public boolean add(Dept dept);

    /**
     * 根据主键查询
     * @param id 主键
     * @return 返回查询结果
     */
    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    public Dept get(Integer id);

    /**
     * 查询所有部门信息
     * @return 返回部门列表
     */
    @RequestMapping(value = "/dept/list",method = RequestMethod.GET)
    public List<Dept> list();

    /**
     * 客户端访问eureka的注册服务信息
     * @return 返回查询的注册服务信息
     */
    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery();
}
