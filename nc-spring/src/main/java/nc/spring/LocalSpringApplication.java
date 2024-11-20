package nc.spring;

import nc.spring.core.NcSpringApplicationContext;
import nc.spring.domain.config.AppConfig;
import nc.spring.domain.service.UserInterface;

public class LocalSpringApplication
{
    public static void main( String[] args )
    {
        NcSpringApplicationContext  applicationContext = new NcSpringApplicationContext(AppConfig.class);
//        UserService userService = (UserService)applicationContext.getBean("userService");
//        userService.test();

//        OrderService orderService = (OrderService)applicationContext.getBean("orderService");
//        orderService.test();

        UserInterface userService = (UserInterface)applicationContext.getBean("userService");
        userService.test();
        userService.testString();
        userService.testBeanName();
    }
}
