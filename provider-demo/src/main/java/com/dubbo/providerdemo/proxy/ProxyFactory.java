package com.dubbo.providerdemo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理工厂实现
 */
public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target){
        this.target = target;
    }

    //给目标对象生成代理对象，其class文件由JVM在运行时动态生成
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            //该方法负责集中处理动态代理类上的所有方法调用
            //第一个参数是代理类实例，第二个参数是被调用方法对象，第三个参数是方法调用参数的数组形式
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //执行目标对象方法，方法参数是target，表示该方法从属于target
                Object invoke = method.invoke(target, args);
                return invoke;
            }
        });
    }

}
