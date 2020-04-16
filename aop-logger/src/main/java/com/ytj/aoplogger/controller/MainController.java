package com.ytj.aoplogger.controller;

import com.ytj.aoplogger.annotation.Log;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @program: MySpringbootStudy
 * @description: MainController
 * @author: admin
 * @create: 2020-04-16 10:38
 **/
@RestController
@RequestMapping("/api")
public class MainController {

    @Log("GET请求")
    @GetMapping("/hello")
    public String hello(HttpServletRequest request) {
        return String.format("Hello from %s", request.getRequestURL().toString());
    }

    @Log("POST请求")
    @PostMapping("/greet")
    public String greet(@RequestBody Map<String, Object> map) {
        return String.format(
                "Hello, %s.\nYou want to %s",
                map.get("username").toString(),
                map.get("action").toString()
        );
    }
}
