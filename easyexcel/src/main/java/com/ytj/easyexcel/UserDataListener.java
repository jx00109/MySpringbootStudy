package com.ytj.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * @program: MySpringbootStudy
 * @description:
 * @author: admin
 * @create: 2020-04-24 15:19
 **/
@Slf4j
public class UserDataListener extends AnalysisEventListener<User> {
    @Override
    public void invoke(User data, AnalysisContext context) {
        log.info("收到数据{}", JSON.toJSONString(data));
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }
}
