package com.ytj.mybatisgenerator.service.impl;

import com.ytj.mybatisgenerator.mapper.UserMapper;
import com.ytj.mybatisgenerator.model.User;
import com.ytj.mybatisgenerator.model.UserExample;
import com.ytj.mybatisgenerator.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: MySpringbootStudy
 * @description: User服务接口实现类
 * @author: admin
 * @create: 2020-04-21 09:22
 **/
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> findUserByUsername(String username) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        return userMapper.selectByExample(userExample);
    }

    @Override
    public int batchUpsert(List<User> users) {
        int n = userMapper.batchUpsert(users);
        return n;
    }

}
