package com.sunny.demo;

import com.alibaba.fastjson.JSON;
import com.sunny.domain.GmsConfig;
import com.sunny.rpc.IGmsConfigService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author dongyangz
 * @date 2018/6/27
 */
public class GmsConfigServiceTest extends CommonTest{

    @Autowired
    private IGmsConfigService gmsConfigService;

    @Test
    public void m1(){
        List<GmsConfig> gmsConfigs = gmsConfigService.selectByObjectList(new GmsConfig());
        logger.info("gmsConfigs={}", JSON.toJSONString(gmsConfigs));
    }
}
