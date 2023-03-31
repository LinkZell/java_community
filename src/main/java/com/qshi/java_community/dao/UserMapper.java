package com.qshi.java_community.dao;

import com.qshi.java_community.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper {
    User selectById(int id);
    User selectByEmail(String email);
    User selectByName(String name);

    //返回的是插入数据的行数
    int insertUser(User user);
    //返回的是修改的条数
    int updateStatus(int id,int status);
    //返回的是更新的条数
    int updateHeaderUrl(int id,String headerUrl);
    //返回的是更新的条数
    int updatePassword(int id,String password);



}
