# 操作记录demo  
使用AOP配合自定义注解方便的实现用户操作的监控。  

## 主要内容  
1. 定义注解  
```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program: MySpringbootStudy
 * @description: 自定义方法级别的注解Log
 * @author: admin
 * @create: 2020-04-16 10:49
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    String value() default "";
}
```
2. 配置切面  
```java
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * @program: MySpringbootStudy
 * @description: 定义一个LogAspect类，使用@Aspect标注让其成为一个切面，切点为使用@Log注解标注的方法
 * @author: admin
 * @create: 2020-04-16 10:50
 **/
@Aspect
@Component
@Slf4j
public class LogAspect {

    //在所有使用了@Log的方法中记入操作日志
    @Pointcut("@annotation(com.ytj.aoplogger.annotation.Log)")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint) {
        saveLog(joinPoint);
    }

    private void saveLog(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        Record record = new Record();
        Log logAnnotation = method.getAnnotation(Log.class);
        if (logAnnotation != null) {
            // 注解上的描述
            record.setMethodName(logAnnotation.value());
        }

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String url = "";

        url = request.getScheme() + "://" + request.getServerName()
                + ":" + request.getServerPort()
                + request.getServletPath();
        if (request.getQueryString() != null) {
            url += "?" + request.getQueryString();
        }

        // 请求的url
        record.setMethodURL(url);

        Object args[] = joinPoint.getArgs();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < args.length; i++) {
            // 如果参数类型是请求和响应的http，则不需要拼接【这两个参数，使用JSON.toJSONString()转换会抛异常】
            if (args[i] instanceof HttpServletRequest
                    || args[i] instanceof HttpServletResponse) {
                continue;
            }
            stringBuilder.append(args[i] == null ? ""
                    : JSON.toJSONString(args[i]));
        }
        record.setMethodParam(stringBuilder.toString());

        //获取用户名
        /*
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            record.setUsername(authentication.getName());
        } else {
            record.setUsername("未登录用户");
        }
        */

        record.setOpIp(HttpHelper.getIpAddr(request));
        record.setOpTime(LocalDateTime.now().toString());
        //在这里可以将日志入库
        log.info("当前操作日志---" + JSON.toJSONString(record));

    }
}
```  
3. 在controller中对需要记录的操作加上注解`@Log`  
```java
@Log("GET请求")
@GetMapping("/hello")
public String hello(HttpServletRequest request) {
    return String.format("Hello from %s", request.getRequestURL().toString());
}

@Log("POST请求")
@PostMapping("/greet")
public String greet(@RequestBody Map<String, Object> map) {
    return String.format(
            "Hello, %s.\nYou want to %s",
            map.get("username").toString(),
            map.get("action").toString()
    );
}
```