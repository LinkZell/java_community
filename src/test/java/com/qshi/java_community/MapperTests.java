package com.qshi.java_community;

import com.qshi.java_community.dao.DiscussPostMapper;
import com.qshi.java_community.dao.UserMapper;
import com.qshi.java_community.entity.DiscussPost;
import com.qshi.java_community.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@EnableAutoConfiguration
@SpringBootTest
@ContextConfiguration(classes = JavaCommunityApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUsers() {
        User user = userMapper.selectById(101);
        System.out.println(user);
        User user1 = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user1);
        User user2 = userMapper.selectByName("liubei");
        System.out.println(user2);
    }
    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("wanger");
        user.setPassword("123");
        user.setSalt("12345");
        user.setEmail("1233@sina.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    void testUpdateUser() {
        userMapper.updateStatus(150,1);
        userMapper.updateHeaderUrl(150,"http://www.nowcoder.com/102.png");
        userMapper.updatePassword(150,"987654321");
    }

    @Test
    void testSelectPost(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0,0,10);
        for(DiscussPost post : list){
            System.out.println(post);
        }
        int rows = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);
    }

}
