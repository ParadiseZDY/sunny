package com.sunny.demo;

import com.sunny.rpc.IStudentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author dongyangz
 * @date 2018/6/27
 */
public class StudentServiceTest extends CommonTest{

    @Autowired
    private IStudentService studentService;

    @Test
    public void testMongo(){
        Integer save = studentService.saveStudent();
        System.out.println(save);
        Integer update = studentService.updateStudent();
        System.out.println(update);
    }
}
