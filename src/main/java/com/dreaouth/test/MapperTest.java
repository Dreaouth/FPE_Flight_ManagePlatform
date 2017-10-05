package com.dreaouth.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * 测试dao层的工作
 * 推荐Spring项目就可以使用Spring的单元测试，可以自动注入我们需要的组件
 * ContextConfiguration指定Spring配置文件的位置
 * 直接autowire要使用的组件即可
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

//    @Autowired
//    UserMapper userMapper;
//
//    @Test
//    public void curdTest(){
//        System.out.println(userMapper);
//        userMapper.insert(new User(2,"liujun","123456",30));
//
//    }
}
