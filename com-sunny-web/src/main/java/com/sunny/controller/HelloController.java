package com.sunny.controller;

import com.sunny.domain.GmsConfig;
import com.sunny.rpc.IGmsConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhao.dy
 * @date 2018/4/16
 */
@RestController
@RequestMapping("/api")
public class HelloController{

    @Autowired
    private IGmsConfigService gmsConfigService;

    @RequestMapping("/getHello")
    public String getHello(){
        return "Hello World!";
    }

    @RequestMapping("/getList")
    public List<GmsConfig> getList(){
        List<GmsConfig> gmsConfigs = gmsConfigService.selectByObjectList(new GmsConfig());
        return gmsConfigs;
    }
}
