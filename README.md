# dubbo 初体验

遇到的一些问题

1、版本问题，dubbo2.6.2之前的版本，xml schemaLocation 要配置成code.alibabatech.com，2.6.2之后的要配置成dubbo.apache.org
  不然会抛异常：Unable to locate Spring NamespaceHandler for XML schema namespace
  
  详解链接：https://blog.csdn.net/qq_31772441/article/details/82533864

2、广播地址<dubbo:registry address="multicast://224.1.1.1:8080"/>，要配置再224.0.0.0~ 239.255.255.255之间，

  详解链接：https://blog.csdn.net/xinguimeng/article/details/84721680
  
3、dubbo2.6.2异步服务调用时，会抛异常Serialized class java.util.concurrent.CompletableFuture must implement java.io.Serializable,原因是采用       dubbo协议，该协议特性中指明：Hessian 二进制序列化，参数及返回值需实现 Serializable 接口，当返回值是CompletableFuture，该对象是JUC对象，并没有实   现序列化接口，所以这是个bug。解决办法：需要升级dubbo版本2.7.4.1，同时更改xml的schemal为dubbo.apache.org，netty升级到io.netty:netty-       all:4.1.43.Final

4、抛异常java.net.BindException: Address already in use: bind，[DUBBO] qos-server can not bind localhost:22222，具体解决办法如下链接：
  https://blog.csdn.net/u012988901/article/details/84503672
   
