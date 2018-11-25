package cn.shuangbofu.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/")
public class TestController {

    @RequestMapping("/hello")
    public String test() {
        return "hello";
    }
}
