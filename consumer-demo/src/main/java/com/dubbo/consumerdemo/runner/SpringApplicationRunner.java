package com.dubbo.consumerdemo.runner;

import com.dubbo.providerdemo.service.DemoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;

@Component
public class SpringApplicationRunner implements CommandLineRunner {

    @Resource
    DemoService demoService;

    @Override
    public void run(String... args) throws Exception {
        String re = demoService.sayHello("CPA");
        System.out.println("============="+re);

        CompletableFuture<String> cf = demoService.asyncSayHello("11");
        System.out.println("====异步调用："+cf.get());
    }
}
