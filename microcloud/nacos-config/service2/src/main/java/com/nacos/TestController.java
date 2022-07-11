package com.nacos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangchao
 * @description TODO
 * @date 2020/08/18 15:06
 */
@RestController
public class TestController {

    @Autowired
    private FeignInterface feignInterface;

    @GetMapping("/getCnf")
    private String getConfig() {
        return feignInterface.getConfigs();
    }
}
