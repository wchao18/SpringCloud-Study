package com.it.service;

import com.it.vo.Dept;

import java.util.List;


public interface IDeptService {
    Dept get(long id);

    boolean add(Dept dept);

    List<Dept> list();
}
