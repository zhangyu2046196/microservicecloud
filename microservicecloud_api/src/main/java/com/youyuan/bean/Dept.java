package com.youyuan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author zhangyu
 * @version 1.0
 * @description 部门实体bean
 * @date 2019/1/2 16:50
 */
@Data//set get toString
@AllArgsConstructor//全参构造方法
@NoArgsConstructor//无参构造方法
@Accessors(chain=true)//链是代码风格
public class Dept implements Serializable { //必须要序列化
    private static final long serialVersionUID = 182102109810366285L;

    public Dept(String deptName) {
        this.deptName = deptName;
    }

    /**
     * 主键
     */
    private Integer deptId;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 来自哪个数据库,因为微服务可以一个服务对应一个数据库
     */
    private String dbSource;

    public static void main(String[] args) {
        Dept dept=new Dept();
        dept.setDeptId(1).setDeptName("技术部").setDbSource("db_source1");//链式代码风格
    }
}
