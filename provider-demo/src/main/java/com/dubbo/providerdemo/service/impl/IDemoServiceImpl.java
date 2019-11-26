package com.dubbo.providerdemo.service.impl;

import com.dubbo.providerdemo.entity.Person;
import com.dubbo.providerdemo.service.IDemoService;

public class IDemoServiceImpl implements IDemoService {
    @Override
    public Person get(int id) {
        return new Person(id,"cpa",29);
    }
}
