package com.it.controller;
import com.it.service.IDeptClientService;
import com.it.vo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 提供方那里加了spring-security安全校验,调用feign接口，所有需要在feign上配置认证信息
 */
@RestController
@RequestMapping("/feign")
public class ConsumerDeptFeignHystrixController {

    @Autowired
    private IDeptClientService deptService ;

    @RequestMapping(value = "/consumer/dept/get")
    public Object getDept(long id) {
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
