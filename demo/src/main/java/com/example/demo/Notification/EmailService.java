package com.example.demo.Notification;

public class EmailService implements NotificationService {

    @Override
    public void EmailNotification() {
        System.out.println("Notification sent");
    }

}
