package com.sunny.service;

import com.mongodb.WriteResult;
import com.sunny.domain.Student;
import com.sunny.rpc.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * @author dongyangz
 * @date 2018/6/27
 */
@Service
public class StudentServiceImpl implements IStudentService{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Integer updateStudent(){
        Query query = new Query(Criteria.where("id").is(1));
        Update update = new Update().set("name","萧炎").set("age",100);
        WriteResult writeResult = mongoTemplate.updateFirst(query, update, Student.class);
        System.out.println(writeResult);
        return 1;
    }

    @Override
    public Integer saveStudent(){
        Student student = new Student(1,"韩立",22,0);
        mongoTemplate.save(student);
        return 1;
    }

    @Override
    public Integer queryStudent(){
        Query query = new Query(Criteria.where("age").is(100));
        Student one = mongoTemplate.findOne(query, Student.class);
        System.out.println(one);
        Query name = new Query(Criteria.where("name").regex(".*?炎.*"));
        Student one1 = mongoTemplate.findOne(name, Student.class);
        System.out.println(one1);
        Student byId = mongoTemplate.findById(1, Student.class);
        System.out.println(byId);
        return 1;
    }

}
