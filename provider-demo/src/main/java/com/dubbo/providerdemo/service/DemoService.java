package com.dubbo.providerdemo.service;

import java.util.concurrent.CompletableFuture;

public interface DemoService {

    String sayHello(String name);

    default CompletableFuture<String> asyncSayHello(String name){
        return CompletableFuture.completedFuture(name);
    };

    String sayHi(String msg);

}
