package com.it.controller;

import com.it.service.IDeptService;
import com.it.vo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class DeptRest {

    @Autowired
    private IDeptService deptService;

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    //服务熔断：本方法执行报错，并不是服务停止了，会执行fallbackmethod方法
    @HystrixCommand(fallbackMethod = "getFallBack")
    public Object get(@PathVariable("id") long id) {
        Dept dept = deptService.get(id);
        if (dept == null) {
            throw new RuntimeException("查询数据为空");
        }
        return dept;
    }

    /**
     * 服务熔断处理方法
     */
    public Object getFallBack(@PathVariable("id") long id) {
        Dept vo = new Dept();
        vo.setDname("hystrix");
        vo.setDeptno(999999999999L);
        return vo;
    }


    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    @HystrixCommand   //如果需要进行性能监控，那么必须要有此注解
    public Object list() {
        return this.deptService.list();
    }
}
