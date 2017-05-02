package com.coison.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/***
 * EnableConfigServer 分析
 * EnableConfigServer ---> ConfigServerConfiguration.Marker.class <--- @ConditionalOnBean
 * -->ConfigServerAutoConfiguration --> EnvironmentRepositoryConfiguration
 *	--->native
 */
@SpringBootApplication
@EnableConfigServer
@RestController
public class ConfigServerApplication {

	@RequestMapping("/")
	public String home() {
		return "云配置中心";
	}

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}
