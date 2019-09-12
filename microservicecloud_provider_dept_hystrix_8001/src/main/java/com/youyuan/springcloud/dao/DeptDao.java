package com.youyuan.springcloud.dao;

import com.youyuan.bean.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zhangyu
 * @version 1.0
 * @description 部门dao
 * @date 2019/1/2 18:46
 */
public interface DeptDao {

    /**
     * 保存
     * @param dept 部门实体bean
     * @return 返回保存结果
     */
    @Insert("insert into dept (dept_name,db_source) values (#{deptName},DATABASE())")
    public boolean add(Dept dept);

    /**
     * 查询
     * @param id 主键
     * @return 返回部门实体bean
     */
    @Select("select dept_id,dept_name,db_source from dept where dept_id=#{id}")
    public Dept get(Integer id);

    /**
     * 查询所有部门信息
     * @return 返回部门列表
     */
    @Select("select dept_id,dept_name,db_source from dept")
    public List<Dept> list();
}
