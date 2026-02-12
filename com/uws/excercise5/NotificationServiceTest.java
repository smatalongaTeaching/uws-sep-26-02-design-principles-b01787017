package com.uws.excercise5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;




class NotificationServiceTest {

    private NotificationService notificationService;
    private EmailSender mockEmailSender;
    private SMSSender mockSmsSender;

    @BeforeEach
    void setUp() throws Exception {
        // Use reflection to inject mocks since NotificationService creates its own dependencies
        notificationService = new NotificationService();
        mockEmailSender = Mockito.mock(EmailSender.class);
        mockSmsSender = Mockito.mock(SMSSender.class);

        java.lang.reflect.Field emailSenderField = NotificationService.class.getDeclaredField("emailSender");
        emailSenderField.setAccessible(true);
        emailSenderField.set(notificationService, mockEmailSender);

        java.lang.reflect.Field smsSenderField = NotificationService.class.getDeclaredField("smsSender");
        smsSenderField.setAccessible(true);
        smsSenderField.set(notificationService, mockSmsSender);
    }

    @Test
    void testSendNotification_Email() {
        String email = "user@example.com";
        String message = "Test email message";

        notificationService.sendNotification(email, message);

        verify(mockEmailSender, times(1)).sendEmail(email, "Notification", message);
        verify(mockSmsSender, never()).sendSMS(anyString(), anyString());
    }

    @Test
    void testSendNotification_SMS() {
        String phone = "1234567890";
        String message = "Test SMS message";

        notificationService.sendNotification(phone, message);

        verify(mockSmsSender, times(1)).sendSMS(phone, message);
        verify(mockEmailSender, never()).sendEmail(anyString(), anyString(), anyString());
    }
}