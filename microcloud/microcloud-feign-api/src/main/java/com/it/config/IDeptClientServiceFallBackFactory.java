package com.it.config;

import com.it.service.IDeptClientService;
import com.it.vo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wangchao
 * @description 服务降级处理,服务不可用的情况下调用
 * @date 2019/09/02 14:02
 */
@Component
public class IDeptClientServiceFallBackFactory implements FallbackFactory<IDeptClientService> {
    @Override
    public IDeptClientService create(Throwable cause) {
        return new IDeptClientService() {
            @Override
            public Dept get(long id) {
                Dept vo = new Dept();
                vo.setDname("hystrix");
                vo.setDeptno(88888888888L);
                return vo;
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}
