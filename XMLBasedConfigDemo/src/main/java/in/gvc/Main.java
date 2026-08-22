package in.gvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

//        OrderService orderService = context.getBean(OrderService.class);
//        orderService.placeOrder();
//        OrderService orderService = (OrderService) context.getBean("orderService");

        OrderService orderService = context.getBean("orderService", OrderService.class);
        orderService.placeOrder();

//        PaymentService paymentService = context.getBean("paymentService", PaymentService.class);
//        paymentService.pay();

    }

}