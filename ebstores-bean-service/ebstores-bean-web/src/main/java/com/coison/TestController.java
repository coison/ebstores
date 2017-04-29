package com.coison;

import com.coison.model.Members;
import com.coison.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * Created by Administrator on 2017/4/28.
 */
@RestController
@EnableAutoConfiguration
public class TestController {

    @Resource
    MembersService membersService;

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/hello/{myName}")
    String index(@PathVariable String myName) {
        List<Members> memberss = membersService.selectAllMembers();
        return "Hello "+memberss+"!!!";
    }
}
