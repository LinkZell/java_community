package com.qshi.java_community.dao;

import com.qshi.java_community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);//此处需要实现动态sql，因为有时候没有给出userid.
    // offset指的是每一页起始行号，limit指的是每一页的数量

    int selectDiscussPostRows(@Param("userId") int userId);//当需要动态使用变量时(在<if>里使用)，并且有且只有一个参数时，必须用@Param取别名



}
