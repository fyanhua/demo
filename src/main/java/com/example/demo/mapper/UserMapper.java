package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
//@Repository
public interface UserMapper {
    //加入数据库
    @Insert("insert into user (name,account_Id,token,gmt_Create,gmt_Modified,avatar_url) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);
    @Select("select * from user where token = #{token}")
    User findBytoken(@Param("token") String token);
    @Select("select * from user where id = #{id}")
    User findById(@Param("id") Integer id);
}

