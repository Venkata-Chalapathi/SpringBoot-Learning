package com.example.demo;

import com.example.demo.Notification.EmailService;
import com.example.demo.Notification.NotificationService;
import com.example.demo.Notification.PopUpNotificationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

//        System.out.println("Hello World");
        NotificationService notification = new PopUpNotificationService();
        OrderService order = new OrderService(notification);
        order.placeOrder();
	}

}
