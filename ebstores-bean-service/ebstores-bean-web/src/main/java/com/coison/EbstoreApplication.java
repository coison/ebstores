package com.coison;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.coison.dao") //扫描自定义路径下面的mapper接口
@SpringBootApplication
@ServletComponentScan //项目中如果需要使用java原生的servlet和filter，可以在类中使用注解实现，主要是配置Druid监控时需要用到
//启注解事务管理
@EnableTransactionManagement
public class EbstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbstoreApplication.class, args);
	}
}
