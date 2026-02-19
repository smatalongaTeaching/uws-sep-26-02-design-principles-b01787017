package com.uws.excercise5;

public class SMSSender implements NotificationChannel {

    @Override
    public void send(String recipient, String message) {
        sendSMS(recipient, message);
    }

    public void sendSMS(String phoneNumber, String message) {
        System.out.println("Sending SMS to " + phoneNumber);
        // SMS sending logic...
    }
}
