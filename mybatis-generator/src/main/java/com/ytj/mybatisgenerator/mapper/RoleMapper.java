package com.ytj.mybatisgenerator.mapper;

import com.ytj.mybatisgenerator.model.Role;
import com.ytj.mybatisgenerator.model.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    int upsert(Role record);

    int upsertSelective(Role record);

    int batchUpsert(@Param("list") List<Role> list);

    int batchUpsertSelective(@Param("list") List<Role> list, @Param("selective") Role.Column ... selective);
}