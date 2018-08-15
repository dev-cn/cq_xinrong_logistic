package cq.anbu.common.utils.common;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BeanUtils {

    public static <T> T nullToBlank(T bean) {
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        Field.setAccessible(declaredFields, true);
        for (int i = 0; i < declaredFields.length; i++) {
            try {
                Object object = declaredFields[i].get(bean);
                if ("class java.lang.String".equalsIgnoreCase(declaredFields[i].getGenericType().toString())) {
                    if (object == null || "null".equals(object)) {
                        declaredFields[i].set(bean, "");
                    }
                }
                else if ("class java.math.BigDecimal".equalsIgnoreCase(declaredFields[i].getGenericType().toString())) {
                    if (object == null || "null".equals(object)) {
                        declaredFields[i].set(bean,new BigDecimal(0));
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        return bean;
    }

    public static <T> List<T> nullToBlankList(List<T> beanList) {
        List<T> list = new ArrayList<>();
        if (beanList == null) {
            return list;
        }
        for (T t : beanList) {
            nullToBlank(t);
            list.add(t);
        }
        return list;
    }
}
