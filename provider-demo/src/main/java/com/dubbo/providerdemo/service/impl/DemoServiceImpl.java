package com.dubbo.providerdemo.service.impl;

import com.dubbo.providerdemo.service.DemoService;

public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello "+name;
    }
}
