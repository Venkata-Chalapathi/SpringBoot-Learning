package in.gvc.SpringBootCoreDemo4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootCoreDemo4Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootCoreDemo4Application.class, args);

//        System.out.println("Hello Spring");

//        PaymentGateway paymentGateway = context.getBean(PaymentGateway.class);
//        paymentGateway.setType("PayTM");
//        paymentGateway.setRetryCount(5);

//        paymentGateway.print();
	}

}
