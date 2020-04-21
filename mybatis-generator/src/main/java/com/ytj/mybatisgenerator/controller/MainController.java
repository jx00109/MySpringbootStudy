package com.ytj.mybatisgenerator.controller;

import com.alibaba.fastjson.JSON;
import com.ytj.mybatisgenerator.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @program: MySpringbootStudy
 * @description: 主控制器
 * @author: admin
 * @create: 2020-04-21 09:51
 **/
@RestController
@Slf4j
@RequestMapping("/api")
public class MainController {

    @Autowired
    UserService userService;

    @PostMapping("/findUserByUsername")
    public String findUserByUsername(@RequestBody Map map) {
        String username = map.get("username").toString();
        return JSON.toJSONString(userService.findUserByUsername(username));
    }

}
