package in.gvc;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private PaymentService paymentService;


    public OrderService(@Lazy PaymentService paymentService) {
        this.paymentService = paymentService;
        System.out.println("OrderService obj created");
    }

    public void placeOrder() {
        paymentService.pay();
        System.out.println("Order Placed");
    }
}
