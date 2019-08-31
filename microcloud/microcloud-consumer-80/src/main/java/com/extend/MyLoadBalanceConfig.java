package com.extend;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangchao
 * @description 这个配置不能被springboot application扫描到
 * @date 2019/08/31 17:35
 */
@Configuration
public class MyLoadBalanceConfig {

  @Bean
  public IRule iRule(){
      //return new com.netflix.loadbalancer.RandomRule();
      return new com.netflix.loadbalancer.AvailabilityFilteringRule();

  }
}
