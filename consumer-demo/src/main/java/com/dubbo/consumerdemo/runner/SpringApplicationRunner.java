package com.dubbo.consumerdemo.runner;

import com.dubbo.consumerdemo.service.impl.NotifyImpl;
import com.dubbo.providerdemo.CallbackListener;
import com.dubbo.providerdemo.entity.Person;
import com.dubbo.providerdemo.service.CallbackService;
import com.dubbo.providerdemo.service.DemoService;
import com.dubbo.providerdemo.service.IDemoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:consumer.xml");
        context.start();
        CallbackService callbackService = (CallbackService) context.getBean("callbackService");
//
        callbackService.addListener("foo.bar", new CallbackListener() {
            @Override
            public void changed(String msg) {
                System.out.println("callback："+msg);
            }
        });

        IDemoService iDemoService = (IDemoService) context.getBean("idemoService");
        NotifyImpl notify = (NotifyImpl) context.getBean("notifyService");
        int requestId = 1;
        Person person = iDemoService.get(requestId);
        for(int i=0;i<10;i++){
            if(!notify.ret.containsKey(requestId)){
                Thread.sleep(2000);
            }else {
                break;
            }
        }
        System.out.println("完毕！！！！");
    }
}
