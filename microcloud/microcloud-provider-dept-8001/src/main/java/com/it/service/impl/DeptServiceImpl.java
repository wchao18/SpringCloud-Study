package com.it.service.impl;

import java.util.List;

import com.it.dao.IDeptDAO;
import com.it.service.IDeptService;
import com.it.vo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeptServiceImpl implements IDeptService {

    @Autowired
    private IDeptDAO deptDAO;

    @Override
    public Dept get(long id) {
        return this.deptDAO.findById(id);
    }

    @Transactional
    @Override
    public boolean add(Dept dept) {
        return this.deptDAO.doCreate(dept);
    }

    @Override
    public List<Dept> list() {
        return this.deptDAO.findAll();
    }

}
