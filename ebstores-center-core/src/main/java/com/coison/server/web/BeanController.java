package com.coison.server.web;

import com.coison.server.command.DemoCommand;
import com.coison.server.feign.RemoteService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/1.
 */
@RestController
@RequestMapping(value = "/api/test")
public class BeanController {

    @Value("${foo}")
    private String foo;

    /**
     * 测试 Hystrix 熔断
     */
    @Resource
    private DemoCommand demoCommand;

    /**
     * 采用Ribbon请求数据
     */
    @Resource
    private RestTemplate client;

    /**
     * 采用Feign请求数据
     */
    @Resource
    private RemoteService remoteService;

    /**
     * 普通数据请求，使用了Hystrix熔断机制，具体看 {@link DemoCommand}
     *
     * @return 对象
     */
    @RequestMapping(method = RequestMethod.GET, value = "/foo")
    public Object getFoo() {
        Map<String, Object> params = Maps.newHashMap();
        params.put("query", foo);
        return demoCommand.getSomething(params);
    }

    /**
     * 使用Feign远程调用，具体看 {@link RemoteService}
     *
     * @return 字符串
     */
    @RequestMapping(method = RequestMethod.GET, value = "/feign")
    public String getFeign() {
        return remoteService.getFoo();
    }

    /**
     * 使用Ribbon请求远程服务，可以自动序列化，这里使用的只是String
     *
     * @return 字符串
     */
    @RequestMapping(method = RequestMethod.GET, value = "/ribbon")
    public String getRemote() {
        return client.getForObject("http://EBSTORES-CENTER-CORE/api/test/foo", String.class);
    }
}
