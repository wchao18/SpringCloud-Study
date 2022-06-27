package com.it.controller;

import com.it.service.IDeptService;
import com.it.vo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;


@RestController
public class DeptRest {

    @Autowired
    private IDeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery() {
        return this.discoveryClient;
    }



    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Object get(@PathVariable("id") long id) {
        //1、超时熔断 2、宕机熔断
        /*try {
            //测试hytrix熔断
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        if(id == 2){
            throw new RuntimeException("服务Dept异常");
        }
        return this.deptService.get(id);
    }

    @RequestMapping(value = "/dept/add", method = RequestMethod.GET)
    public Object add(@RequestBody Dept dept) {
        return this.deptService.add(dept);
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public Object list() {
        try {
            //测试超时降级
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.deptService.list();
    }

    //测试session
    @RequestMapping(value = "/session", method = RequestMethod.GET)
    public Object list(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getSession().getId();
    }

}
