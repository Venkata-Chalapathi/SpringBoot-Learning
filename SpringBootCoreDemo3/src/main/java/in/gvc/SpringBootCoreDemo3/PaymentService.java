package in.gvc.SpringBootCoreDemo3;

import org.springframework.stereotype.Component;

@Component
public class PaymentService {


    public void pay() {
        System.out.println("Payment Done");
    }
}
