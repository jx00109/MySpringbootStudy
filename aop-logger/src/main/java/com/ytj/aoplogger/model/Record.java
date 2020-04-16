package com.ytj.aoplogger.model;

import lombok.Data;

/**
 * @program: MySpringbootStudy
 * @description: 日志实体
 * @author: admin
 * @create: 2020-04-16 10:54
 **/
@Data
public class Record {
    private Long id;
    private String username;
    private String methodName;
    private String methodURL;
    private String opTime;
    private String opIp;
    private String methodParam;
}
