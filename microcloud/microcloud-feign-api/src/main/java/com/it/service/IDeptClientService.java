package com.it.service;

import com.it.config.FeignClientConfig;
import com.it.vo.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@FeignClient(value = "MICROCLOUD-PROVIDER-DEPT", configuration = FeignClientConfig.class)
public interface IDeptClientService {
    @RequestMapping(method = RequestMethod.GET, value = "/dept/get/{id}")
    public Dept get(@PathVariable("id") long id);

    @RequestMapping(method = RequestMethod.GET, value = "/dept/list")
    public List<Dept> list();

    @RequestMapping(method = RequestMethod.POST, value = "/dept/add")
    public boolean add(Dept dept);
}
