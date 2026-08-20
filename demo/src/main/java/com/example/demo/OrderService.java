package com.example.demo;

import com.example.demo.Notification.EmailService;
import com.example.demo.Notification.NotificationService;

public class OrderService {

//    NotificationService notification = new EmailService();
    NotificationService notification;

    public OrderService(NotificationService notification){
        this.notification = notification;
    }

    public void setNotification(NotificationService notification) {
        this.notification = notification;
    }

    public void placeOrder() {
        System.out.println("Order Placed");

        notification.EmailNotification();
    }

}
