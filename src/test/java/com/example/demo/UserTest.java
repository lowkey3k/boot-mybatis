package com.example.demo;

import com.example.demo.mapper.one.User;
import com.example.demo.mapper.one.UserMapper;
import com.example.demo.util.RandomUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.util.List;

/**
 * @author haitao.li
 * @description:
 * @date 2021/2/7 15:40
 */
@SpringBootTest
public class UserTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() {

        User user = new User();
        for (int i = 0; i < 8000000; i++) {
            user.setUsername(RandomUtils.randomName());
            user.setGrade(RandomUtils.randomGrade());
            user.setAge(RandomUtils.randomInt(15, 30));
            user.setPhone("1" + RandomUtils.randomInt(3, 8) + RandomUtils.randomInt(9) + RandomUtils.randomString("0123456789", 8));
            user.setSex(RandomUtils.randomSex(true));
            userMapper.insert(user);
        }

    }

    /**
     * 无索引
     * 数据量  where条件    耗时（ms)
     * 100     age>18     900左右
     *
     */
    /**
     * 有索引
     * 数据量  where条件    耗时（ms)
     * 100     age>18     900左右
     */
    @Test
    public void test02() {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Page<Object> objects = PageHelper.startPage(10, 100000).doSelectPage(() -> {
            List<User> select = userMapper.select();
        });
        stopWatch.stop();
        System.err.println("耗时：" + stopWatch.getTotalTimeMillis());

    }

}
