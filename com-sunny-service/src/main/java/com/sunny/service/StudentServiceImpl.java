package com.sunny.service;

import com.sunny.rpc.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * @author dongyangz
 * @date 2018/6/27
 */
@Service
public class StudentServiceImpl implements IStudentService{

    @Autowired
    private MongoTemplate mongoTemplate;

}
