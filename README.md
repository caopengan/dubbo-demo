# dubbo 初体验

遇到的一些问题

1、版本问题，dubbo2.6.2之前的版本，xml schemaLocation 要配置成code.alibabatech.com，2.6.2之后的要配置成dubbo.apache.org
  不然会抛异常：Unable to locate Spring NamespaceHandler for XML schema namespace
  
  详解链接：https://blog.csdn.net/qq_31772441/article/details/82533864

2、广播地址<dubbo:registry address="multicast://224.1.1.1:8080"/>，要配置再224.0.0.0~ 239.255.255.255之间，

  详解链接：https://blog.csdn.net/xinguimeng/article/details/84721680
