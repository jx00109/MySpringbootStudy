# 属性复制工具  
1. Map与Bean的属性复制  
2. Bean与Bean之间的属性复制  
```java
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
        // 第一个参数：源对象， 第二个参数：目标对象，第三个参数：是否使用自定义转换器
        BeanCopier b = BeanCopier.create(source.getClass(), target.getClass(), false);
        b.copy(source, target, null);

        return target;
    }
}
```  
