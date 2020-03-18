package com.hyl.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 韩宇龙
 * @create 2020-03-15 9:10
 */

@EnableTransactionManagement //启用事务管理
@Configuration
@MapperScan("com.hyl.mapper")
public class UserServiceConfig {

}
