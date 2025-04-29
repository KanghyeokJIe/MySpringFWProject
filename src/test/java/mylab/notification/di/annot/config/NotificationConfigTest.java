package mylab.notification.di.annot.config;

import mylab.notification.di.annot.NotificationManager;
import mylab.notification.di.annot.NotificationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(
    classes = NotificationConfig.class,
    loader = AnnotationConfigContextLoader.class
)
public class NotificationConfigTest {

    @Autowired
    NotificationManager notificationManager;

    @Autowired
    @Qualifier("emailNotificationService")
    NotificationService emailService;

    @Autowired
    @Qualifier("smsNotificationService")
    NotificationService smsService;

    @Test
    void testNotificationManager() {
        assertNotNull(notificationManager);
        assertNotNull(emailService);
        assertNotNull(smsService);

        notificationManager.sendNotificationByEmail("이메일 알림 테스트");
        notificationManager.sendNotificationBySms("SMS 알림 테스트");
    }
}
