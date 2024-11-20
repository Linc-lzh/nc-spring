package nc.spring.core.service;



import nc.spring.core.BeanPostProcessor;
import nc.spring.core.Component;

import java.lang.reflect.Field;
@Component
public class NcValueBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {

        for (Field field : bean.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(NcValue.class)) {
                field.setAccessible(true);
                try {
                    field.set(bean, field.getAnnotation(NcValue.class).value());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return bean;
    }
}
