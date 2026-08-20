package in.gvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    @Autowired
    private OrderService orderService;

//    @Autowired
//    public PaymentService(OrderService orderService){
//        this.orderService = orderService;
//    }


    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public void pay() {
        System.out.println("Payment Done");
//        orderService.getOrderDetails();
    }
}
