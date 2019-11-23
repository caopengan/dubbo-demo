package com.dubbo.consumerdemo.runner;

import com.dubbo.providerdemo.service.DemoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SpringApplicationRunner implements CommandLineRunner {

    @Resource
    DemoService demoService;

    @Override
    public void run(String... args) throws Exception {
        String helloStr = demoService.sayHello("CPA");
        System.out.println("============="+helloStr);
    }
}
