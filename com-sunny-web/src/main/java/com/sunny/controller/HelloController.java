package com.sunny.controller;

import com.google.common.collect.Lists;
import com.sunny.domain.GmsConfig;
import com.sunny.rpc.IGmsConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhao.dy
 * @date 2018/4/16
 */
@RestController
@RequestMapping("/api")
public class HelloController{

    private static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private IGmsConfigService gmsConfigService;

    @RequestMapping("/getHello")
    public String getHello(){
        return "Hello World!";
    }

    @RequestMapping("/getList")
    public List<GmsConfig> getList(int i){
        long start = System.currentTimeMillis();
        List<GmsConfig> gmsConfigs = Lists.newArrayList();
        for (int j = 0; j < i; j++) {
            gmsConfigs = gmsConfigService.selectByObjectList(new GmsConfig());
        }
        logger.info("getList.speed={}ms",System.currentTimeMillis() - start);
        return gmsConfigs;
    }

    @RequestMapping(value = "/getListFromCache",method = RequestMethod.POST,produces = "application/json;charset=UTF-8" )
    public List<GmsConfig> getListFromCache(int i){
        long start = System.currentTimeMillis();
        List<GmsConfig> configList = Lists.newArrayList();
        for (int j = 0; j < i; j++) {
            configList = gmsConfigService.getListFromCache(new GmsConfig());
        }
        logger.info("getListFromCache.speed={}ms",System.currentTimeMillis() - start);
        return configList;
    }
}
