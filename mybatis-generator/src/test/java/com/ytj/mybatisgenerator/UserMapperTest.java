package com.ytj.mybatisgenerator;

import com.ytj.mybatisgenerator.model.User;
import com.ytj.mybatisgenerator.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：ytj
 * @date ：2020/4/21 20:14
 * @description：用户mapper测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@Slf4j
public class UserMapperTest {

    @Autowired
    UserService userService;

    @Test
    public void testBatchUpsert() {
        User admin = userService.findUserByUsername("admin").get(0);
        User user = userService.findUserByUsername("user").get(0);

        admin.setCompanyName("修改admin的company_name");

        user.setCompanyCode("修改user的company_code");

        User boy = new User();
        boy.setId(3);
        boy.setCompanyName("boy company");
        boy.setUsername("boy");
        boy.setOrderConsigneeAddress("浙江省杭州市");

        log.info("修改前\n{}\n{}\n{}\n", admin, user, boy);


        List<User> users = new ArrayList<>();
        users.add(admin);
        users.add(user);
        users.add(boy);

        int n=userService.batchUpsert(users);
        log.info("受影响的记录数目：{}", n);

    }
}
