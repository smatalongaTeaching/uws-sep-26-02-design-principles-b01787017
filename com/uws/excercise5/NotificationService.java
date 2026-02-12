package com.uws.excercise5;

public class NotificationService {
    private EmailSender emailSender;
    private SMSSender smsSender;
    
    public NotificationService() {
        this.emailSender = new EmailSender(); // Direct dependency on concrete class
        this.smsSender = new SMSSender();     // Direct dependency on concrete class
    }
    
    public void sendNotification(String user, String message) {
        if (user.contains("@")) { //Covert type check
            // Assume it's an email
            emailSender.sendEmail(user, "Notification", message);
        } else {
            // Assume it's a phone number
            smsSender.sendSMS(user, message);
        }
    }

}
