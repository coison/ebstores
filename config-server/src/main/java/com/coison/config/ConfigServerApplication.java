package com.coison.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/***
 * EnableConfigServer 分析
 * EnableConfigServer ---> ConfigServerConfiguration.Marker.class <--- @ConditionalOnBean
 * -->ConfigServerAutoConfiguration --> EnvironmentRepositoryConfiguration
 *	--->native
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}
}
