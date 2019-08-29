package com.it.dao;

import java.util.List;

import com.it.vo.Dept;

public interface IDeptDAO {

    boolean doCreate(Dept vo);

    Dept findById(Long id);

    List<Dept> findAll();
}
