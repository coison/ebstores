package com.coison.server.command;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 测试熔断
 *
 * Created by Administrator on 2017/5/1.
 */
@Component
public class DemoCommand {
    /**
     * 这里的HystrixCommand有很多配置，这里只是最简单的一种，意思是当发生异常的时候，会自动调用下面的备用方法
     *
     * @param params 参数
     * @return 结果
     */
    @HystrixCommand(fallbackMethod = "defaultProcess")
    public Object getSomething(Map<String, Object> params) {
        return "你好";
    }

    /**
     * 在此例中意思是备用方法
     *
     * @param params 参数
     * @return 结果
     */
    public Object defaultProcess(Map<String, Object> params) {
        return "默认的处理函数——调用失败";
    }
}
