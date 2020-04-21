package com.ytj.aoplogger.config;

import com.alibaba.fastjson.JSON;
import com.ytj.aoplogger.utils.HttpHelper;
import com.ytj.aoplogger.annotation.Log;
import com.ytj.aoplogger.model.Record;

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
