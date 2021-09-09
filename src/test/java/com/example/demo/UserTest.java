package com.example.demo;

import com.example.demo.mapper.one.User;
import com.example.demo.mapper.one.UserMapper;
import com.example.demo.util.RandomUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author haitao.li
 * @description:
 * @date 2021/2/7 15:40
 */
@Slf4j
@SpringBootTest
public class UserTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() {

        User user = new User();
        for (int i = 0; i < 8; i++) {
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

    /**
     * rowBounds分页
     */
    @Test
    public void test03() {
        List<User> users = userMapper.selectPage(new RowBounds(5, 10));
        log.info("users:{}", users);
    }

    /**
     * 自定义PageInterceptor分页
     */
    @Test
    public void test04() {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(5);
        pageInfo.setPageSize(5);
        List<User> users = userMapper.selectPageByInterceptor(pageInfo);
        log.info("users:{}", users);
    }

    /**
     * PageHelper分页
     */
    @Test
    public void test05() {
        PageHelper.startPage(0, 5);
        List<User> users = userMapper.selectPageHelper();
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        log.info("pageInfo:{}", pageInfo);
    }
}
