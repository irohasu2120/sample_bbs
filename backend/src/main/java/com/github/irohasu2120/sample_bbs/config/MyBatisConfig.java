package com.github.irohasu2120.sample_bbs.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.github.irohasu2120.sample_bbs.db.mapper")
public class MyBatisConfig {
}
