package in.gvc;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("singleton")
@Scope("prototype")
public class OrderService {

    public OrderService() {
        System.out.println("OrderService obj created");
    }
    public void placeOrder() {
        System.out.println("Order Placed");
    }

}
