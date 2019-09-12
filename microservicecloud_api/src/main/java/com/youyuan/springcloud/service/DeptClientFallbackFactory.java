package com.youyuan.springcloud.service;

import com.youyuan.bean.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhangyu
 * @version 1.0
 * @description 服务降级需要编写一个类，实现FallbackFactory接口，接口泛型传递要降级的业务类
 * @date 2019/1/6 20:36
 */
@Component
public class DeptClientFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            /**
             *  查询接口做演示，指定降级处理的逻辑
             * @param id 主键
             * @return
             */
            @Override
            public Dept get(Integer id) {
                return new Dept().setDeptId(id).setDeptName("服务已关闭,请选择其它服务地址......").setDbSource("没有数据库可用");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public Object discovery() {
                return null;
            }
        };
    }
}
