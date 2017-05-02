package com.coison.server.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * Created by Administrator on 2017/5/1.
 */

@FeignClient(name = "EBSTORES-CENTER-CORE")
public interface RemoteService {
    /**
     * <p>里面的/api/demo/foo意味着你将要发起一个请求，请求的程序名就是程序名已经在FeignClient的name中指定了。</p>
     * <p>你可以简单的认为FeignClient注解指明了一个DNS解析，然后里面所有的路径将会解析到那个程序上</p>
     *
     * @return 字符串
     */
    @RequestMapping(value = "/api/test/foo", method = RequestMethod.GET)
    String getFoo();
}
