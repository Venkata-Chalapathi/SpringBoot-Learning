package in.gvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

//        OrderService orderService = context.getBean(OrderService.class);
//        orderService.placeOrder();

//        CartService cartService = context.getBean(CartService.class);
//        cartService.addToCart();
//        System.out.println(cartService.getValue(1));
//
//        context.close();


    }
}