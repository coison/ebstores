package com.coison.server;

import com.netflix.discovery.DiscoveryManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient   //通过该注解，实现服务发现，注册
@EnableCircuitBreaker
@EnableHystrix
@RefreshScope
@EnableFeignClients
public class EbstoresCenterCoreApplication implements ApplicationRunner {

	/**
	 * 用于校验云配置是否配置成功
	 */
	@Value("${foo}")
	private String foo;

	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			DiscoveryManager.getInstance().shutdownComponent();
		}));
		SpringApplication.run(EbstoresCenterCoreApplication.class,args);
	}

	/**
	 * 启用Ribbon的软负载均衡
	 *
	 * @return RestTemplate
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		RestTemplate template = new RestTemplate();
		SimpleClientHttpRequestFactory factory = (SimpleClientHttpRequestFactory) template.getRequestFactory();
		factory.setConnectTimeout(3000);
		factory.setReadTimeout(3000);
		return template;
	}

	/**
	 * 运行后打印一个无关的属性，用于确认云配置是否成功
	 *
	 * @param args 参数
	 * @throws Exception 异常
	 */

	@Override
	public void run(ApplicationArguments args) throws Exception {
//		log.info(foo);
	}
}
