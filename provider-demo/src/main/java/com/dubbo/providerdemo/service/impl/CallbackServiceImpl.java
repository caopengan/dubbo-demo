package com.dubbo.providerdemo.service.impl;

import com.dubbo.providerdemo.CallbackListener;
import com.dubbo.providerdemo.service.CallbackService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CallbackServiceImpl implements CallbackService {

    private final Map<String,CallbackListener> listeners = new HashMap<String,CallbackListener>();

    public CallbackServiceImpl() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        for(Map.Entry<String,CallbackListener> entry : listeners.entrySet()){
                            try {
                                entry.getValue().changed(entry.getKey());
                            } catch (Exception e) {
                                listeners.remove(entry.getKey());
                                e.printStackTrace();
                            }
                        }
                        //定时触发变更通知
                        Thread.sleep(5000);
                    } catch (Exception e) {
                        //防御容错
                        e.printStackTrace();
                    }
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }

    @Override
    public void addListener(String key, CallbackListener callbackListener) {
        listeners.put(key,callbackListener);
        callbackListener.changed(getChanged(key));
    }

    private String getChanged(String key){
        return "Changed："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

}
