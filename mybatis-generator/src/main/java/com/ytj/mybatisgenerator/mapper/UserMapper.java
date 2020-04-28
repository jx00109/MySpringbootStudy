package com.ytj.mybatisgenerator.mapper;

import com.ytj.mybatisgenerator.model.User;
import com.ytj.mybatisgenerator.model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component("userMapper")
public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int upsert(User record);

    int upsertSelective(User record);

    int batchUpsert(@Param("list") List<User> list);

    int batchUpsertSelective(@Param("list") List<User> list, @Param("selective") User.Column ... selective);
}