package com.dubbo.providerdemo.service;

import com.dubbo.providerdemo.CallbackListener;

public interface CallbackService {

    void addListener(String key, CallbackListener callbackListener);

}
