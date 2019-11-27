package com.dubbo.providerdemo.service.impl;

import com.dubbo.providerdemo.service.SecondService;

public class SecondServiceImpl implements SecondService {
    @Override
    public String test(String key) {
        System.out.println("=====输出关键词："+key);
        return "test  "+key;
    }
}
