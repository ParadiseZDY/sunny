package com.sunny.controller;

import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author dongyangz
 * @date 2018/6/14
 */
@Component
public class ConstantController {

    public static final Map<String,String> map = ImmutableMap.of("男","张三","女","李四");

}
