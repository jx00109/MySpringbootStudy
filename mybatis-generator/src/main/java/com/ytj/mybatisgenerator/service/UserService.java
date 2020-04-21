package com.ytj.mybatisgenerator.service;

import com.ytj.mybatisgenerator.model.User;

import java.util.List;

/**
 * @program: MySpringbootStudy
 * @description: User服务接口
 * @author: admin
 * @create: 2020-04-21 09:20
 **/
public interface UserService {
    List<User> findUserByUsername(String username);
}
