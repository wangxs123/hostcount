package cn.shuangbofu.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {


    @RequestMapping("/addPage")
    public ModelAndView add() {
        return new ModelAndView("add");
    }

    @RequestMapping("/index")
    public String index() {
        return "forward:/addPage";
    }

    @RequestMapping("/")
    public String root() {
        return "forward:/index";
    }

    @RequestMapping("/list")
    public String list() {
        return "list";
    }
}
