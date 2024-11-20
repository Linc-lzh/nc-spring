package nc.spring.core.service;


import nc.spring.core.BeanPostProcessor;
import nc.spring.core.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Component
public class NcCustomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if(beanName.equals("userService")) {
            Object proxyInstance = Proxy.newProxyInstance(NcCustomBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("point cut logic");
                    return method.invoke(bean,args);
                }
            });

            return proxyInstance;
        }
        return bean;
    }
}
