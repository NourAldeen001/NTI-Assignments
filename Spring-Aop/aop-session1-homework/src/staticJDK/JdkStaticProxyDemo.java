package staticJDK;

public class JdkStaticProxyDemo {
    public static void main(String[] args) {

        NotificationServiceImpl real = new NotificationServiceImpl();

        NotificationProxy proxy = new NotificationProxy(real);

        proxy.sendEmail("NourEldin Ali", "Welcome, Nour in AOP World!");
        proxy.sendSms("+201098426593", "Welcome, Nour in AOP World!");

    }
}