package com.uws.excercise5;

public class NotificationService {

    private final NotificationChannel emailChannel;
    private final NotificationChannel smsChannel;

    public NotificationService(NotificationChannel emailChannel, NotificationChannel smsChannel) {
        this.emailChannel = emailChannel;
        this.smsChannel = smsChannel;
    }

    public void sendNotification(String user, String message) {
        if (user.contains("@")) { 
            emailChannel.send(user, message);
        } else {
            smsChannel.send(user, message);
        }
    }
}
