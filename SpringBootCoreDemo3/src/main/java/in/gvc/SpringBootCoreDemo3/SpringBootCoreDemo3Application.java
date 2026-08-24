package in.gvc.SpringBootCoreDemo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootCoreDemo3Application {

	public static void main(String[] args) {
		ApplicationContext context =
                SpringApplication.run(SpringBootCoreDemo3Application.class, args);

        OrderService orderService = context.getBean(OrderService.class);
        orderService.placeOrder();

	}

    @Bean
    public UserService getUser(){
        return new UserService();
    }

}
