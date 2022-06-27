package com.it.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.it.service.IDeptClientService;
import com.it.vo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class ConsumerDeptSentinelController {

    @Autowired
    private IDeptClientService deptService;

    //Sentinel上指定热点规则，必须要配置这个
    //热点参数限流对默认的SpringMVC资源无效
    @SentinelResource("hotParam")
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
