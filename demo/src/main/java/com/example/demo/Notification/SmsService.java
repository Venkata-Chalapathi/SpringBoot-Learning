package com.example.demo.Notification;

public class SmsService implements NotificationService{

    @Override
    public void EmailNotification() {
        System.out.println("Sms Notification sent");
    }

}
