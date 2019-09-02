package com.it.service.impl;

import java.util.List;

import com.it.dao.IDeptDAO;
import com.it.service.IDeptService;
import com.it.vo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl implements IDeptService {

    @Autowired
    private IDeptDAO deptDAO;

    @Override
    public Dept get(long id) {
        return this.deptDAO.findById(id);
    }

    @Override
    public List<Dept> list() {
        return this.deptDAO.findAll();
    }

}
