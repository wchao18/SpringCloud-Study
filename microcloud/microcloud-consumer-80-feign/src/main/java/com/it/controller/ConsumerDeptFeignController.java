package com.it.controller;

import com.it.service.IDeptClientService;
import com.it.vo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 提供方那里加了spring-security安全校验
 */
@RestController
@RequestMapping("/feign")
public class ConsumerDeptFeignController {

    @Autowired
    private IDeptClientService deptService;

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Object getDept(@PathVariable("id") long id) {
        if (id == 4) {
            //被调用服务停止了,这个不受影响
            return "正常访问";
        }
        return this.deptService.get(id);
    }

    @RequestMapping(value = "/consumer/dept/list")
    public Object listDept() {
        return this.deptService.list();
    }

    @RequestMapping(value = "/consumer/dept/add")
    public Object addDept(Dept dept) {
        return this.deptService.add(dept);
    }
}
