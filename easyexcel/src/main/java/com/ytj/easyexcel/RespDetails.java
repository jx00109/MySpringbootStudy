package com.ytj.easyexcel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: MySpringbootStudy
 * @description: 统一封装
 * @author: admin
 * @create: 2020-04-27 15:21
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespDetails {
    private Integer status;
    private Object data;
    private String msg;
}
