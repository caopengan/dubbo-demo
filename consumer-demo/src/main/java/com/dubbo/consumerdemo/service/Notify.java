package com.dubbo.consumerdemo.service;

import com.dubbo.providerdemo.entity.Person;
import org.springframework.stereotype.Service;

@Service
public interface Notify {

    public void onReturn(Person person,int id);
    public void onThrow(Throwable throwable,int id);

}
