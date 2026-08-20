package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        PaymentService paymentService = new PaymentService();
//        OrderService orderService = new OrderService(paymentService);
//        orderService.placeOrder();

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        OrderService order = context.getBean(OrderService.class);
        order.placeOrder();

//        PaymentService paymentService = context.getBean(PaymentService.class);
//        paymentService.pay();

        User user = context.getBean(User.class);
        System.out.println(user.getName());

    }
}