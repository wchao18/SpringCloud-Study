package com.it.controller;

import com.it.vo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * 提供方那里加了spring-security安全校验
 */
@RestController
@RequestMapping("/security")
public class ConsumerDeptHeaderController {
    public static final String DEPT_GET_URL = "http://127.0.0.1:8001/dept/get/";
    public static final String DEPT_LIST_URL = "http://127.0.0.1:8001/dept/list/";
    public static final String DEPT_ADD_URL = "http://127.0.0.1:8001/dept/add";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders httpHeaders;

    @RequestMapping(value = "/consumer/dept/get")
    public Object getDept(long id) {
        Dept dept = this.restTemplate.exchange(DEPT_GET_URL + id, HttpMethod.GET,
                new HttpEntity<>(httpHeaders), Dept.class).getBody();
        return dept;
    }

    @RequestMapping(value = "/consumer/dept/list")
    public Object listDept() {
        List<Dept> allDepts = this.restTemplate.exchange(DEPT_LIST_URL,
                HttpMethod.GET, new HttpEntity<>(httpHeaders), List.class).getBody();
        return allDepts;
    }

    @RequestMapping(value = "/consumer/dept/add")
    public Object addDept(@RequestBody Dept dept) {
        Boolean flag = this.restTemplate.exchange(DEPT_ADD_URL
                , HttpMethod.POST, new HttpEntity<>(dept, httpHeaders), Boolean.class).getBody();
        return flag;
    }
}
