//package com.coison.server.web;
//
//import com.coison.server.service.EbstoresMembersService;
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//
///**
// *
// * Created by Administrator on 2017/4/30.
// */
//@RestController
//@Configurable
//public class HelloController {
//
////    @Autowired
////    private RestTemplate restTemplate;
//
//    @RequestMapping(value = "/")
//    public String hello(){
//        return "hello spring boot !";
//    }
//
//    @Resource
//    EbstoresMembersService ebstoresMembersService;
//
//    @RequestMapping(value = "/his",method = RequestMethod.GET)
//    public String sayHi(@RequestParam String name){
//        return ebstoresMembersService.sayHiFromClientOne(name);
//    }
//
////    @RequestMapping("/hi")
////    public String home(@RequestParam String name) {
////        String forObject = this.restTemplate.getForObject("http://localhost:8081/hi?name=" + name,
////                String.class);
////        return forObject;
////    }
//}
