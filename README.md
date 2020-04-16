# 从零开始学习 Spring Boot  
对Spring Boot开发过程中的相关技术做一下简单记录  

## Maven相关  
Q: 如何在Maven子项目中继承Maven父项目的依赖  
A: 在父项目pom的dependencies标签前加入dependencyManangement标签  
```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>

        <!-- https://mvnrepository.com/artifact/com.alibaba/fastjson -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.62</version>
        </dependency>
    </dependencies>
</dependencyManagement>
```   


