package dynamicJDK;

import java.lang.reflect.Proxy;

public class JdkDynamicProxyDemo {
    public static void main(String[] args) {

//        NotificationServiceImpl real = new NotificationServiceImpl();
//
//        NotificationService proxy = (NotificationService) Proxy.newProxyInstance(
//                NotificationService.class.getClassLoader(),
//                new Class[]{NotificationService.class}, // , PaymentService.class
//                new LoggingHandler(real)
//        );
//
//        proxy.sendEmail("NourEldin Ali", "Welcome, Nour in AOP World!");
//        proxy.sendSms("+201098426593", "Welcome, Nour in AOP World!");

/// ===================================================================================

        NotificationServiceImpl real1 = new NotificationServiceImpl();
        PaymentServiceImpl real2 = new PaymentServiceImpl();


//        MultiClassLoader multiClassLoader = new MultiClassLoader();
//
//        multiClassLoader.addLoader(NotificationService.class.getClassLoader());
       // multiClassLoader.addLoader(PaymentService.class.getClassLoader());

        Object proxy = Proxy.newProxyInstance(
                NotificationService.class.getClassLoader(), // Where -> ClassLoader.getSystemClassLoader()
                new Class[]{NotificationService.class, PaymentService.class},
                new LoggingHandler(real1, real2)
        );

        PaymentService proxy1 = (PaymentService) proxy;
        NotificationService proxy2 = (NotificationService) proxy;


        proxy1.pay(155.5);
        proxy2.sendEmail("NourEldin Ali", "Welcome, Nour in AOP World!");
        proxy2.sendSms("+201098426593", "Welcome, Nour in AOP World!");



    }
}