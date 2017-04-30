package com.coison.eureka;

import de.codecentric.boot.admin.config.EnableAdminServer;
import de.codecentric.boot.admin.notify.LoggingNotifier;
import de.codecentric.boot.admin.notify.Notifier;
import de.codecentric.boot.admin.notify.RemindingNotifier;
import de.codecentric.boot.admin.notify.filter.FilteringNotifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableAdminServer
public class EurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceApplication.class, args);
	}

	@Profile("secure")
	@Configuration
	public static class SecurityConfig extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// Page with login form is served as /login.html and does a POST on /login
			http.formLogin().loginPage("/login.html").loginProcessingUrl("/login").permitAll();
			// The UI does a POST on /logout on logout
			http.logout().logoutUrl("/logout");
			// The ui currently doesn't support csrf
			http.csrf().disable();

			// Requests for the login page and the static assets are allowed
			http.authorizeRequests()
					.antMatchers("/login.html", "/**/*.css", "/img/**", "/third-party/**")
					.permitAll();
			// ... and any other request needs to be authorized
			http.authorizeRequests().antMatchers("/**").authenticated();

			// Enable so that the clients can authenticate via HTTP basic for registering
			http.httpBasic();
		}
	}
	// end::configuration-spring-security[]

	/***
	 * 发送关于下载/脱机应用程序的提醒，它将通知的发送委托给另一个通知程序
	 * 默认情况下，当注册的应用程序更改为DOWN或时，将触发提醒OFFLINE。你可以通过改变这个行为setReminderStatuses()。当状态更改为非触发状态或相关应用程序取消注册时，提醒结束。
	 */
	@Configuration
	public static class NotifierConfig {
		@Bean
		@Primary
		public RemindingNotifier remindingNotifier() {
			RemindingNotifier notifier = new RemindingNotifier(filteringNotifier(loggerNotifier()));
			notifier.setReminderPeriod(TimeUnit.SECONDS.toMillis(5)); //	提醒将每5分钟发送一次。
			return notifier;
		}

		@Scheduled(fixedRate = 10_000L)  //计划每1秒发送一次到期提醒。
		public void remind() {
			remindingNotifier().sendReminders();
		}

		@Bean
		public FilteringNotifier filteringNotifier(Notifier delegate) {
			return new FilteringNotifier(delegate);
		}

		@Bean
		public LoggingNotifier loggerNotifier() {
			return new LoggingNotifier();
		}
	}

}
