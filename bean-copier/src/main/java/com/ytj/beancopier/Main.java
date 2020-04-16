package com.ytj.beancopier;

import com.ytj.beancopier.model.BigUser;
import com.ytj.beancopier.model.SmallUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.beans.BeanMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: MySpringbootStudy
 * @description: Main Class
 * @author: admin
 * @create: 2020-04-16 09:34
 **/
@Slf4j
public class Main {
    public static void main(String[] args) {
        //创建两个用于属性复制的对象
        BigUser big = new BigUser();
        big.setName("Tom");
        big.setAge(27);
        big.setAddress("浙江省嘉兴市");

        SmallUser small = new SmallUser();
        small.setName("Jack");
        small.setAge(17);

        Map map = new HashMap();
        map.put("name", "Lucky");
        map.put("age", 34);

        log.info("----------------复制前----------------");

        log.info("BigUser: {}", big);
        log.info("SmallUser: {}", small);
        //模拟前端传来的参数
        log.info("received Map: {}", map);

        log.info("----------------map2bean----------------");
        SmallUser su = new SmallUser();
        BigUser bu = new BigUser();
        su = mapToBean(map, su);
        bu = mapToBean(map, bu);
        log.info("BigUser: {}", bu);
        log.info("SmallUser: {}", su);

        log.info("----------------bean2bean----------------");

        BigUser bigUser = beanToBean(small, big);
        log.info("BigUser: {}", bigUser);
        log.info("SmallUser: {}", small);

    }

    /**
     * 将map装换为javabean对象
     *
     * @param map
     * @param bean
     * @return
     */
    public static <T> T mapToBean(Map<String, Object> map, T bean) {

        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);

        return bean;
    }

    /**
     * 两个bean之间的属性复制
     *
     * @param source
     * @param target
     * @param <T1>
     * @param <T2>
     * @return
     */
    public static <T1, T2> T2 beanToBean(T1 source, T2 target) {
        // 第一个参数：源对象， 第二个参数：目标对象，第三个参数：是否使用自定义转换器（下面会介绍），下同
        BeanCopier b = BeanCopier.create(source.getClass(), target.getClass(), false);
        b.copy(source, target, null);

        return target;
    }
}
