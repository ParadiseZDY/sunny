package com.sunny.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.mongodb.DB;
import com.sunny.domain.GmsConfig;
import com.sunny.rpc.IGmsConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author zhao.dy
 * @date 2018/4/16
 */
@RestController
@RequestMapping("/api")
public class HelloController{

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private IGmsConfigService gmsConfigService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("/getHello")
    public String getHello(){
        return "Hello World!";
    }

    @RequestMapping("/getList")
    public List<GmsConfig> getList(){
        List<GmsConfig> gmsConfigs = gmsConfigService.selectByObjectList(new GmsConfig());
        return gmsConfigs;
    }

    /**
     * curl http://127.0.0.1:18000/api/getMethod?param=abc
     * @param param
     * @return
     */
    @RequestMapping(value = "/getMethod",method = RequestMethod.GET)
    public Map<String,String> getMethod(String param){
        ImmutableMap<String, String> map = ImmutableMap.of(param, param);
        logger.info("getMethod.map={}", JSON.toJSONString(map));
        return map;
    }

    /**
     * curl -d "param=123" http://127.0.0.1:18000/api/postMethod
     * @param param
     * @return
     */
    @RequestMapping(value = "/postMethod",method = RequestMethod.POST)
    public Map<String,String> postMethod(String param){
        ImmutableMap<String, String> map = ImmutableMap.of(param, param);
        logger.info("postMethod.map={}", JSON.toJSONString(map));
        return map;
    }

    /**
     * curl -H "Content-Type:application/json" -X POST -d '{"key":"key"}' http://127.0.0.1:18000/api/postMethodJson
     * @param config
     * @return
     */
    @RequestMapping(value = "/postMethodJson",method = RequestMethod.POST)
    public List<GmsConfig> postMethodJson(@RequestBody GmsConfig config){
        List<GmsConfig> configList = gmsConfigService.selectByObjectList(config);
        return configList;
    }

    @RequestMapping("/redisKeys")
    public Set<String> keys(){
        Set keys = redisTemplate.keys("*");
        System.out.println(JSON.toJSONString(keys));
        return keys;
    }

    @RequestMapping("/setKey")
    public String setKey(String key,String value){
        ValueOperations forValue = redisTemplate.opsForValue();
        forValue.set(key,value,10, TimeUnit.SECONDS);
        return (String) forValue.get(key);
    }

    @RequestMapping("/setHash")
    public Map setHash(String key1,String key2,String value){
        HashOperations forHash = redisTemplate.opsForHash();
        forHash.put(key1,key2,value);
        List list = forHash.multiGet(key1, Lists.newArrayList(key2));
        System.out.println(list);
        Map map = forHash.entries(key1);
        System.out.println(map);
        return map;
    }

    @RequestMapping("/setMongo")
    public void setMongo(){
        DB db = mongoTemplate.getDb();
        String name = db.getName();
        boolean flag = db.collectionExists("myconnection");
        System.out.println(name + ":" + flag);
    }
}
