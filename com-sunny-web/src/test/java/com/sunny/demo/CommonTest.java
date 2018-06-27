package com.sunny.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author dongyangz
 * @date 2018/6/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CommonTest {

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void commonTest(){
        //单元测试父类
    }
}
