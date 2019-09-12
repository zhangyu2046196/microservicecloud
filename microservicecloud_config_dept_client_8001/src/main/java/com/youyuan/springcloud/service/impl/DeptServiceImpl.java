package com.youyuan.springcloud.service.impl;

import com.youyuan.bean.Dept;
import com.youyuan.springcloud.dao.DeptDao;
import com.youyuan.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangyu
 * @version 1.0
 * @description 部门业务接口
 * @date 2019/1/2 18:55
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean add(Dept dept) {
        return deptDao.add(dept);
    }

    @Override
    public Dept get(Integer id) {
        return deptDao.get(id);
    }

    @Override
    public List<Dept> list() {
        return deptDao.list();
    }
}
