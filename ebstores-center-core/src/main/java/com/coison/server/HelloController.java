package com.coison.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * Created by Administrator on 2017/4/30.
 */
@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/")
    public String hello(){
        return "hello spring boot !";
    }

    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        String forObject = this.restTemplate.getForObject("http://localhost:8081/hi?name=" + name,
                String.class);
        return forObject;
    }
}
