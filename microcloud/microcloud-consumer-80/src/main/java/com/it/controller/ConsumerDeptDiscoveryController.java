package com.it.controller;

import com.it.vo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ConsumerDeptDiscoveryController {
    public static final String APP_NAME = "http://MICROCLOUD-PROVIDER-DEPT-8001";
    public static final String DEPT_GET_URL = APP_NAME + "/dept/get/";
    public static final String DEPT_LIST_URL = APP_NAME + "/dept/list/";
    public static final String DEPT_ADD_URL = APP_NAME + "/dept/add";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/get")
    public Object getDept(long id) {
        Dept dept = this.restTemplate.getForObject(DEPT_GET_URL + id,
                Dept.class);
        return dept;
    }

    @RequestMapping(value = "/consumer/dept/list")
    public Object listDept() {
        List<Dept> allDepts = this.restTemplate.getForObject(DEPT_LIST_URL,
                List.class);
        return allDepts;
    }

    @RequestMapping(value = "/consumer/dept/add")
    public Object addDept(@RequestBody Dept dept) {
        Boolean flag = this.restTemplate.postForObject(DEPT_ADD_URL, dept,
                Boolean.class);
        return flag;
    }
}
