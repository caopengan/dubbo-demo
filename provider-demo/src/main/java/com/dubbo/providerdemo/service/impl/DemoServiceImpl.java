package com.dubbo.providerdemo.service.impl;

import com.dubbo.providerdemo.service.DemoService;

import java.util.concurrent.CompletableFuture;

public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello "+name;
    }

    @Override
    public CompletableFuture<String> asyncSayHello(String name) {
        return CompletableFuture.supplyAsync(() -> "async Hello");
    }
}
