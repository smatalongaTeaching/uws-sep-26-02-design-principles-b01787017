package com.uws.excercise5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class NotificationServiceTest {

    private NotificationService notificationService;
    private NotificationChannel mockEmailChannel;
    private NotificationChannel mockSmsChannel;

    @BeforeEach
    void setUp() {
        mockEmailChannel = mock(NotificationChannel.class);
        mockSmsChannel = mock(NotificationChannel.class);
        notificationService = new NotificationService(mockEmailChannel, mockSmsChannel);
    }

    @Test
    void testSendNotification_Email() {
        String email = "user@example.com";
        String message = "Test email message";

        notificationService.sendNotification(email, message);

        verify(mockEmailChannel, times(1)).send(email, message);
        verify(mockSmsChannel, never()).send(anyString(), anyString());
    }

    @Test
    void testSendNotification_SMS() {
        String phone = "1234567890";
        String message = "Test SMS message";

        notificationService.sendNotification(phone, message);

        verify(mockSmsChannel, times(1)).send(phone, message);
        verify(mockEmailChannel, never()).send(anyString(), anyString());
    }
}
