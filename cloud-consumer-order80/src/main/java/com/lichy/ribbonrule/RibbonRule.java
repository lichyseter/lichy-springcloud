package com.lichy.ribbonrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonRule {

    @Bean(name = "myRibbonRule")
    public IRule ribbonRule() {
        return new RandomRule();
    }
}
