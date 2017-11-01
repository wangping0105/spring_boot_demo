package com.jack.spring_boot_demo.controller;

import com.jack.spring_boot_demo.database.Users;
import com.jack.spring_boot_demo.model.User;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.Map.Entry;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class HomeController {
    private final Logger log = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

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
        log.info("-----这个是version接口！");
        return map;
    }

    @GetMapping("/users/{id}")
    @ResponseBody
    public String test(@PathVariable("id")  Integer id){
        Users users = new Users();
        return users.findUserById(id).toString();
    }
}
