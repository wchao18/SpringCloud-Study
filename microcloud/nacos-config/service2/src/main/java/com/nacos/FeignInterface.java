package com.nacos;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wangchao
 * @description TODO
 * @date 2020/08/18 15:01
 */
@FeignClient(name = "service1")
public interface FeignInterface {

    @GetMapping("/configs")
    String getConfigs();
}
