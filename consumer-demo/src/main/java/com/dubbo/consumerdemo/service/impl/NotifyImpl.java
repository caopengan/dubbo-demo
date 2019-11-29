package com.dubbo.consumerdemo.service.impl;

import com.dubbo.consumerdemo.service.Notify;
import com.dubbo.providerdemo.entity.Person;

import java.util.HashMap;
import java.util.Map;

public class NotifyImpl implements Notify {

    public Map<Integer,Person> ret = new HashMap<Integer,Person>();
    public Map<Integer,Throwable> errors = new HashMap<Integer,Throwable>();

    @Override
    public void onReturn(Person person, int id) {
        System.out.println("调用返回Person："+person);
        ret.put(id,person);
    }

    @Override
    public void onThrow(Throwable throwable, int id) {
        errors.put(id,throwable);
    }
}
