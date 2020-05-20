package com.ytj.easyexcel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class User {
    @ExcelProperty(index = 0, value = {"用户序号"})
    private long id;

    @ExcelProperty(index = 1, value = {"基本信息", "用户名"})
    private String username;

    @ExcelIgnore
    private String password;

    @ExcelProperty(index = 2, value = {"联系人信息", "联系电话"})
    private String contactNumber;

    @ExcelProperty(index = 3, value = {"联系人信息", "联系人姓名"})
    private String name;

    @ExcelProperty(index = 4, value = {"联系人信息", "所属部门"})
    private String department;

    @ExcelProperty(index = 5, value = {"乡镇信息", "乡镇名称"})
    private String townName;

    @ExcelProperty(index = 6, value = {"乡镇信息", "乡镇代码"})
    private String townCode;

}
