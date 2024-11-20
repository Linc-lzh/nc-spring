package nc.spring.domain.service;

import nc.spring.core.Autowired;
import nc.spring.core.Component;
import nc.spring.core.InitializingBean;
import nc.spring.core.Scope;
import nc.spring.core.service.BeanNameAware;
import nc.spring.core.service.NcValue;

@Component("userService")
@Scope("prototype")
public class UserService implements InitializingBean, UserInterface, BeanNameAware {

    @Autowired
    private OrderService orderService;
    @NcValue("test linc string")
    private String testString;

    private String beanName;

    public void  test()
    {
        System.out.println("test UserService");
    }

    public void  testBeanName()
    {
        System.out.println(beanName);
    }

    public void  testString()
    {
        System.out.println(testString);
    }

    public void  testAutowired()
    {
        System.out.println(orderService);
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("initializing...");
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
}
