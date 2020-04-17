# 从零开始学习 Spring Boot  
对Spring Boot开发过程中的相关技术做一下简单记录  

## Maven相关  
Q: 如何在Maven子项目中继承Maven父项目的依赖?  
1.在父项目pom中添加`packing`标签  
```xml
<packaging>pom</packaging>
```   
2.在父项目pom中添加`modules`标签  
```xml
<modules>
    <!--添加子项目的artifactId -->
    <module>bean-copier</module>
    <module>aop-logger</module>
</modules>
```  
3.在子项目pom中添加`parent`标签  
```xml
<parent>
    <groupId>com.ytj</groupId>
    <artifactId>MySpringbootStudy</artifactId>
    <version>1.0-SNAPSHOT</version>
</parent>
```
4.重新加载maven依赖`reimport`


