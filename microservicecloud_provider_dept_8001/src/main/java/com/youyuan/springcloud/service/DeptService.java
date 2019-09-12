package com.youyuan.springcloud.service;

import com.youyuan.bean.Dept;

import java.util.List;

/**
 * @author zhangyu
 * @version 1.0
 * @description 部门业务接口
 * @date 2019/1/2 18:53
 */
public interface DeptService {

    /**
     * 添加
     * @param dept 部门实体bean
     * @return 返回保存结果
     */
    public boolean add(Dept dept);

    /**
     * 根据主键查询
     * @param id 主键
     * @return 返回部门实体bean
     */
    public Dept get(Integer id);

    /**
     * 查询部门所有信息
     * @return 返回部门列表
     */
    public List<Dept> list();
}
