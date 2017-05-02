package com.coison.eureka;

import de.codecentric.boot.admin.config.EnableAdminServer;
import de.codecentric.boot.admin.notify.LoggingNotifier;
import de.codecentric.boot.admin.notify.Notifier;
import de.codecentric.boot.admin.notify.RemindingNotifier;
import de.codecentric.boot.admin.notify.filter.FilteringNotifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/5/3.
 */
@SpringBootApplication
@EnableAdminServer
public class NotifierConfig {

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
