package com.jack.spring_boot_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = GET)
    public String index(Model model){
        String hello = "Hello world";
        model.addAttribute("hello", hello);

        return "index";
    }

    @GetMapping("/version")
    @ResponseBody
    public Map version(@RequestParam("name") String paramsStr){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("version", "1.0.0");
        map.put("name", paramsStr);
        return map;
    }
}
