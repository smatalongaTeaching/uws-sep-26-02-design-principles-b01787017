package com.uws.excercise5;

public class EmailSender implements NotificationChannel {

    @Override
    public void send(String recipient, String message) {
        sendEmail(recipient, "Notification", message);
    }

    public void sendEmail(String recipient, String subject, String message) {
        System.out.println("Sending email to " + recipient + " with subject: " + subject);
        // Email sending logic...
    }
}
