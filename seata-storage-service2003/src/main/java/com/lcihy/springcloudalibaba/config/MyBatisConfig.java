package com.lcihy.springcloudalibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.lichy.springcloudalibaba.dao"})
public class MyBatisConfig {
}
