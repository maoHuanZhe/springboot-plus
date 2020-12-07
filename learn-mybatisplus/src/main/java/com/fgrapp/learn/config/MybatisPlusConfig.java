package com.fgrapp.learn.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlusConfig
 *
 * @author fan guang rui
 * @date 2020年12月07日 16:37
 */
@Configuration
@MapperScan("com.fgrapp.learn.dao")
public class MybatisPlusConfig {
}
